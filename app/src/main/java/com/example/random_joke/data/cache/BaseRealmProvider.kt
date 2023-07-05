package com.example.random_joke.data.cache

import android.content.Context
import com.example.random_joke.core.data.cache.RealmProvider
import io.realm.Realm
import io.realm.RealmConfiguration

class BaseRealmProvider(context: Context, useMock: Boolean) : RealmProvider {

    init {
        Realm.init(context)
        val fileName = if (useMock) MOCK else NAME
        val config = RealmConfiguration.Builder().name(fileName).build()
        Realm.setDefaultConfiguration(config)
    }
    override fun provide(): Realm = Realm.getDefaultInstance()

    companion object{
        const val MOCK = "jokesAndQuotesRealmMock"
        const val NAME = "jokesAndQuotesRealm"
    }

}