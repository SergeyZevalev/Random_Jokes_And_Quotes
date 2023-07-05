package com.example.random_joke.data.cache

import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.core.data.ChangeCommonItem
import com.example.random_joke.core.data.ChangeStatus
import com.example.random_joke.core.data.cache.CachedData


class BaseCachedData<E> : CachedData<E> {

    private var cached: ChangeCommonItem<E> = ChangeCommonItem.Empty()
    override fun save(data: CommonDataModel<E>) {
        cached = data
    }

    override fun clear() {
        cached = ChangeCommonItem.Empty()
    }

    override suspend fun change(changeStatus: ChangeStatus<E>): CommonDataModel<E> {
        return cached.change(changeStatus)
    }
}