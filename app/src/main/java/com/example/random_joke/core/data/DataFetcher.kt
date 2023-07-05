package com.example.random_joke.core.data

import com.example.random_joke.data.CommonDataModel

interface DataFetcher<E> {

    suspend fun getData(): CommonDataModel<E>
}