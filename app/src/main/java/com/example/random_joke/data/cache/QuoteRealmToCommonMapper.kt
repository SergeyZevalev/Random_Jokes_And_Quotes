package com.example.random_joke.data.cache

import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.core.data.cache.RealmToCommonDataMapper

class QuoteRealmToCommonMapper: RealmToCommonDataMapper<QuoteRealmModel, String> {
    override fun map(realmObject: QuoteRealmModel): CommonDataModel<String> {
        return CommonDataModel(realmObject.id, realmObject.content, realmObject.author, true)
    }
}