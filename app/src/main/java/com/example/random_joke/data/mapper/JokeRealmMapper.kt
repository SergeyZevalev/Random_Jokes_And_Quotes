package com.example.random_joke.data.mapper

import com.example.random_joke.core.data.CommonDataModelMapper
import com.example.random_joke.data.cache.JokeRealmModel

class JokeRealmMapper : CommonDataModelMapper<JokeRealmModel, Int> {
    override fun map(id: Int, first: String, second: String, cached: Boolean): JokeRealmModel {
        return JokeRealmModel().also {
            it.id = id
            it.text = first
            it.punchline = second
        }
    }
}