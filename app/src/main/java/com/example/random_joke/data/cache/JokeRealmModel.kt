package com.example.random_joke.data.cache

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class JokeRealmModel : RealmObject() {
    @PrimaryKey
    var id: Int = -1
    var text: String = ""
    var punchline: String = ""
}