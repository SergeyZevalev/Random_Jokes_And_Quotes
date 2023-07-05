package com.example.random_joke.core.data.cache

import io.realm.Realm

interface RealmProvider {

    fun provide() : Realm
}