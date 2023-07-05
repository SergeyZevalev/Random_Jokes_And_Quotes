package com.example.random_joke

import com.example.random_joke.core.domain.NoCachedDataException
import com.example.random_joke.core.domain.NoConnectionException
import com.example.random_joke.data.BaseRepository
import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.data.cache.BaseCachedData
import com.example.random_joke.data.cache.BaseTestDataProvider
import com.example.random_joke.data.cache.TestCachedDataSource
import com.example.random_joke.data.cache.TestCachedObject
import com.example.random_joke.data.net.TestCloudDataSource
import com.example.random_joke.data.net.TestCloudObject
import com.example.random_joke.domain.BaseTestCachedToCommonMapper
import com.example.random_joke.domain.BaseTestCommonToCachedMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class BaseModelTest {

    @ExperimentalCoroutinesApi
    @Test()
    fun testWithoutExceptions() = runBlocking {
        val database = BaseTestDataProvider()
        val mapper = BaseTestCommonToCachedMapper()
        val commonMapper = BaseTestCachedToCommonMapper()
        val testCachedDataSource = TestCachedDataSource(database, mapper, commonMapper)

        val testCloudDataSource = TestCloudDataSource<Int>(true)
        val repository = BaseRepository(testCachedDataSource, testCloudDataSource, BaseCachedData())

        val actual = repository.getCommonItem()
        val expected = TestCloudObject(0).map()
        assertEquals(true, actual == expected)

        repository.changeStatus()
        repository.chooseDataSource(true)

        val actual1 = repository.getCommonItem()
        val expected2 = CommonDataModel(0, "test text 0", "test punchline 0", true)
        assertEquals(true, actual1 == expected2)
    }

    @ExperimentalCoroutinesApi
    @Test(expected = NoConnectionException::class)
    fun testNoConnectionException() = runBlocking {
        val database = BaseTestDataProvider()
        val mapper = BaseTestCommonToCachedMapper()
        val commonMapper = BaseTestCachedToCommonMapper()
        val testCachedDataSource = TestCachedDataSource(database, mapper, commonMapper)

        val testCloudDataSource = TestCloudDataSource<Int>(false)
        val repository = BaseRepository(testCachedDataSource, testCloudDataSource, BaseCachedData())

        val actual = repository.getCommonItem()
    }

    @ExperimentalCoroutinesApi
    @Test(expected = NoCachedDataException::class)
    fun testNoCachedDataException() = runBlocking {
        val database = BaseTestDataProvider()
        val mapper = BaseTestCommonToCachedMapper()
        val commonMapper = BaseTestCachedToCommonMapper()
        val testCachedDataSource = TestCachedDataSource(database, mapper, commonMapper)

        val testCloudDataSource = TestCloudDataSource<Int>(false)
        val repository = BaseRepository(testCachedDataSource, testCloudDataSource, BaseCachedData())

        repository.chooseDataSource(true)
        val actual = repository.getCommonItem()
    }
}