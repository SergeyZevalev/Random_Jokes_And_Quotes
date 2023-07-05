package com.example.random_joke.core.data.cache

import com.example.random_joke.core.data.ChangeCommonItem
import com.example.random_joke.data.CommonDataModel

interface CachedData<E> : ChangeCommonItem<E> {
    fun save(data: CommonDataModel<E>)
    fun clear()
}
