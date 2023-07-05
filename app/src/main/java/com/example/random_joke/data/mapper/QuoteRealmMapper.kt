package com.example.random_joke.data.mapper

import com.example.random_joke.core.data.CommonDataModelMapper
import com.example.random_joke.data.cache.QuoteRealmModel

class QuoteRealmMapper : CommonDataModelMapper<QuoteRealmModel, String> {
    override fun map(id: String, first: String, second: String, cached: Boolean) =
        QuoteRealmModel().also {
            it.id = id
            it.content = first
            it.author = second
        }

}