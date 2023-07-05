package com.example.random_joke.domain

import com.example.random_joke.data.cache.TestCachedObject
import com.example.random_joke.core.data.CommonDataModelMapper

class BaseTestCommonToCachedMapper: CommonDataModelMapper<TestCachedObject, Int> {
    override fun map(id: Int, first: String, second: String, cached: Boolean): TestCachedObject {
        return TestCachedObject(id, first, second)
    }
}