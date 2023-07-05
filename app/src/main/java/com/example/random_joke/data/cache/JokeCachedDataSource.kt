package com.example.random_joke.data.cache

import com.example.random_joke.data.mapper.JokeRealmMapper
import com.example.random_joke.core.data.cache.RealmProvider
import io.realm.Realm

class JokeCachedDataSource(
    realmProvider: RealmProvider, mapper: JokeRealmMapper, commonDataMapper: JokeRealmToCommonMapper
) : BaseCachedDataSource<JokeRealmModel, Int>(realmProvider, mapper, commonDataMapper) {

    override val dbClass = JokeRealmModel::class.java
    override fun findRealmObject(realm: Realm, id: Int): JokeRealmModel? {
        return realm.where(dbClass).equalTo("id", id).findFirst()
    }
}