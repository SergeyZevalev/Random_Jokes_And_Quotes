package com.example.random_joke.core.domain

import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.data.cache.TestCachedObject

interface TestCachedToCommonDataMapper<E> {

    fun map(cachedObject: TestCachedObject) : CommonDataModel<E>
}