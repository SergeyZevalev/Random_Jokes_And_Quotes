package com.example.random_joke.core.data.cache

import com.example.random_joke.data.CommonDataModel
import io.realm.RealmObject

interface RealmToCommonDataMapper<T: RealmObject, E> {

    fun map(realmObject: T): CommonDataModel<E>
}