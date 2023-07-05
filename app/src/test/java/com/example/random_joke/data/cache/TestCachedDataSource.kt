package com.example.random_joke.data.cache

import com.example.random_joke.core.data.TestBaseProvider
import com.example.random_joke.core.domain.TestCachedToCommonDataMapper
import com.example.random_joke.core.data.CommonDataModelMapper
import com.example.random_joke.core.data.cache.CacheDataSource
import com.example.random_joke.core.domain.NoCachedDataException
import com.example.random_joke.data.CommonDataModel

class TestCachedDataSource<T: TestCachedObject, E: Int>(
    private val testBaseProvider: TestBaseProvider,
    private val mapper: CommonDataModelMapper<T, E>,
    private val commonMapper: TestCachedToCommonDataMapper<E>
): CacheDataSource<E> {


    override suspend fun addOrRemoveIt(id: E, model: CommonDataModel<E>): CommonDataModel<E> {
        val data = testBaseProvider.provide().find(id)
        return if (data == null) {
            val item = model.map(mapper)
            testBaseProvider.provide().add(item)
            model.changeCached(true)
        } else {
            testBaseProvider.provide().findAndRemove(id)
            model.changeCached(false)
        }
    }

    override suspend fun getDataList(): List<CommonDataModel<E>> = getTestModelData{ results ->
        results.map { commonMapper.map(it) }
    }

    override suspend fun remove(id: E) {
        testBaseProvider.provide().findAndRemove(id)
    }

    override suspend fun getData(): CommonDataModel<E> = getTestModelData {
        commonMapper.map(it.random())
    }


    private fun <R> getTestModelData (block: (list: List<TestCachedObject>) -> R) : R {
        val data = testBaseProvider.provide().provideList()
        if (data.isEmpty()) throw NoCachedDataException()
        else return block.invoke(data)
    }
}