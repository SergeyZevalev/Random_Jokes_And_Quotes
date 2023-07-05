package com.example.random_joke.data.net

import com.example.random_joke.core.data.net.CloudDataSource
import com.example.random_joke.core.domain.NoConnectionException
import com.example.random_joke.data.CommonDataModel

class TestCloudDataSource<E>(private val success: Boolean): CloudDataSource<E> {

    private var result = success

    private var count = -1

    private fun getTestServerData(): TestCloudObject {
        count++
        return TestCloudObject(count)
    }

    override suspend fun getData(): CommonDataModel<E> {
        if (!success) throw NoConnectionException()
        return (getTestServerData().map() as CommonDataModel<E>)
    }

    fun changeResult(){
        result = !result
    }
}