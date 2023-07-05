package com.example.random_joke.domain

import com.example.random_joke.data.cache.TestCachedObject
import com.example.random_joke.core.domain.TestCachedToCommonDataMapper
import com.example.random_joke.data.CommonDataModel

class BaseTestCachedToCommonMapper: TestCachedToCommonDataMapper<Int> {

    override fun map(cachedObject: TestCachedObject): CommonDataModel<Int> {
        val id = cachedObject.objectId
        return CommonDataModel(id, "test text $id", "test punchline $id", true)
    }
}