package com.example.random_joke.data.cache

import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.core.data.CommonDataModelMapper
import com.example.random_joke.core.data.cache.CacheDataSource
import com.example.random_joke.core.data.cache.RealmProvider
import com.example.random_joke.core.data.cache.RealmToCommonDataMapper
import com.example.random_joke.core.domain.NoCachedDataException
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseCachedDataSource<T: RealmObject, E>(
    private val realmProvider: RealmProvider,
    private val mapper: CommonDataModelMapper<T, E>,
    private val commonDataMapper: RealmToCommonDataMapper<T, E>
) : CacheDataSource<E> {

    protected abstract val dbClass: Class<T>

    protected abstract fun findRealmObject(realm: Realm, id: E) : T?

    override suspend fun getDataList() = getRealmData {results ->
        results.map { commonDataMapper.map(it) }
    }

    override suspend fun addOrRemoveIt(id: E, model: CommonDataModel<E>): CommonDataModel<E> =
        withContext(Dispatchers.IO) {
            realmProvider.provide().use {
                val realmItem =
                    findRealmObject(it, id)
                return@withContext if (realmItem == null) {
                    it.executeTransaction { transaction ->
                        val newData = model.map(mapper)
                        transaction.insert(newData)
                    }
                    model.changeCached(true)
                } else {
                    it.executeTransaction {
                        realmItem.deleteFromRealm()
                    }
                    model.changeCached(false)
                }
            }
        }


    override suspend fun getData() = getRealmData {
        commonDataMapper.map(it.random())
    }

    private fun <R> getRealmData(block : (list: RealmResults<T>) -> R) : R{
        realmProvider.provide().use {
            val list = it.where(dbClass).findAll()
            if (list.isEmpty()) throw NoCachedDataException()
            else {
                return block.invoke(list)
            }
        }
    }

    override suspend fun remove(id: E) = withContext(Dispatchers.IO){
        realmProvider.provide().use {realm ->
            realm.executeTransaction{
                findRealmObject(realm, id)?.deleteFromRealm()
            }
        }
    }
}