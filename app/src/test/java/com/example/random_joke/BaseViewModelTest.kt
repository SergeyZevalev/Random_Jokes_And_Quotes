package com.example.random_joke
import com.example.random_joke.data.BaseRepository
import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.data.CommonSuccessMapper
import com.example.random_joke.data.cache.BaseCachedData
import com.example.random_joke.data.cache.BaseTestDataProvider
import com.example.random_joke.data.cache.TestCachedDataSource
import com.example.random_joke.data.cache.TestCachedObject
import com.example.random_joke.data.net.TestCloudDataSource
import com.example.random_joke.data.net.TestCloudObject
import com.example.random_joke.domain.BaseInteractor
import com.example.random_joke.domain.BaseTestCachedToCommonMapper
import com.example.random_joke.domain.BaseTestCommonToCachedMapper
import com.example.random_joke.domain.TestFailureFactory
import com.example.random_joke.presentation.BaseCommunication
import com.example.random_joke.presentation.TestViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

//class BaseViewModelTest {
//
//
//    @ExperimentalCoroutinesApi
//    @Test
//    fun test(): Unit = runBlocking{
//        val database = BaseTestDataProvider()
//        val mapper = BaseTestCommonToCachedMapper()
//        val commonMapper = BaseTestCachedToCommonMapper()
//        val testCachedDataSource = TestCachedDataSource(database, mapper, commonMapper)
//
//        val testCloudDataSource = TestCloudDataSource<Int>(true)
//        val repository = BaseRepository(testCachedDataSource, testCloudDataSource, BaseCachedData())
//
//        val communication = BaseCommunication<Int>()
//        val failureHandler = TestFailureFactory()
//        val successMapper = CommonSuccessMapper<Int>()
//        val interactor = BaseInteractor(repository, failureHandler, successMapper)
//
//        val viewModel = TestViewModel(interactor, communication)
//
//    }
//
//}