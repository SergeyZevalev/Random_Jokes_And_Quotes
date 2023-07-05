package com.example.random_joke.core.data.cache

import com.example.random_joke.core.data.ChangeStatus
import com.example.random_joke.core.data.DataFetcher
import com.example.random_joke.data.CommonDataModel

interface CacheDataSource<E> : DataFetcher<E>, ChangeStatus<E> {

    suspend fun getDataList(): List<CommonDataModel<E>>
    suspend fun remove(id: E)
}