package com.example.random_joke.core.data

import com.example.random_joke.data.cache.TestObjectDataBase

interface TestBaseProvider {

    fun provide(): TestObjectDataBase
}