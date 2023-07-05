package com.example.random_joke.data.cache

import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.core.data.cache.RealmToCommonDataMapper

class JokeRealmToCommonMapper: RealmToCommonDataMapper<JokeRealmModel, Int> {
    override fun map(realmObject: JokeRealmModel): CommonDataModel<Int> {
        return CommonDataModel(realmObject.id, realmObject.text, realmObject.punchline, true)
    }
}