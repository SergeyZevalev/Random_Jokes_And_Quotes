package com.example.random_joke.sl

import com.example.random_joke.data.BaseRepository
import com.example.random_joke.data.CommonSuccessMapper
import com.example.random_joke.data.cache.BaseCachedData
import com.example.random_joke.data.cache.QuoteCachedDataSource
import com.example.random_joke.data.cache.QuoteRealmToCommonMapper
import com.example.random_joke.data.mapper.QuoteRealmMapper
import com.example.random_joke.data.net.QuoteCloudDataSource
import com.example.random_joke.core.data.net.QuoteService
import com.example.random_joke.domain.BaseInteractor
import com.example.random_joke.presentation.BaseCommunication
import com.example.random_joke.presentation.QuotesViewModel

class QuotesModule(
    private val instancesProvider: CommonInstancesProvider
) : BaseModule.Base<String, QuotesViewModel>() {

    override fun getViewModel() = QuotesViewModel(getInteractor(), BaseCommunication())

    private fun getInteractor() =
        BaseInteractor(getRepository(), instancesProvider.provideFailureHandler(), CommonSuccessMapper())

    private fun getRepository() = BaseRepository(
        getCacheDataSource(),
        getCloudDataSource(),
        BaseCachedData()
    )

    private fun getCacheDataSource() =
        QuoteCachedDataSource(instancesProvider, QuoteRealmMapper(), QuoteRealmToCommonMapper())

    private fun getCloudDataSource() = QuoteCloudDataSource(instancesProvider.makeService(
        QuoteService::class.java))
}