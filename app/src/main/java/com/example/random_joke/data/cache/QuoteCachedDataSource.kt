package com.example.random_joke.data.cache

import com.example.random_joke.data.mapper.QuoteRealmMapper
import com.example.random_joke.core.data.cache.RealmProvider
import io.realm.Realm

class QuoteCachedDataSource(
    realmProvider: RealmProvider, mapper: QuoteRealmMapper, commonMapper: QuoteRealmToCommonMapper
) : BaseCachedDataSource<QuoteRealmModel, String>(realmProvider, mapper, commonMapper) {

    override val dbClass = QuoteRealmModel::class.java
    override fun findRealmObject(realm: Realm, id: String): QuoteRealmModel? {
        return realm.where(dbClass).equalTo("id", id).findFirst()
    }
}