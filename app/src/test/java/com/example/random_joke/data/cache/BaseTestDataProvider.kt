package com.example.random_joke.data.cache

import com.example.random_joke.core.data.TestBaseProvider

class BaseTestDataProvider: TestBaseProvider {

    private val database = TestObjectDataBase()

    override fun provide(): TestObjectDataBase {
        return database
    }
}