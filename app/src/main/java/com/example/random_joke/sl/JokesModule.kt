package com.example.random_joke.sl

import com.example.random_joke.data.BaseRepository
import com.example.random_joke.data.CommonSuccessMapper
import com.example.random_joke.data.cache.BaseCachedData
import com.example.random_joke.data.cache.JokeCachedDataSource
import com.example.random_joke.data.cache.JokeRealmToCommonMapper
import com.example.random_joke.data.mapper.JokeRealmMapper
import com.example.random_joke.data.net.JokeCloudDataSource
import com.example.random_joke.core.data.net.JokeService
import com.example.random_joke.data.test.MockJokeCloudDataSource
import com.example.random_joke.domain.BaseInteractor
import com.example.random_joke.presentation.BaseCommunication
import com.example.random_joke.presentation.JokesViewModel

class JokesModule(
    private val instancesProvider: CommonInstancesProvider,
    private val useMock: Boolean
) : BaseModule.Base<Int, JokesViewModel>() {


    override fun getViewModel(): JokesViewModel {
        return JokesViewModel(getInteractor(), BaseCommunication())
    }


    private fun getInteractor() = BaseInteractor(
        getRepository(),
        instancesProvider.provideFailureHandler(),
        CommonSuccessMapper()
    )

    private fun getRepository() =
        BaseRepository(getCachedDataSource(), getCloudDataSource(), BaseCachedData())

    private fun getCachedDataSource() =
        JokeCachedDataSource(instancesProvider, JokeRealmMapper(), JokeRealmToCommonMapper())

    private fun getCloudDataSource() =
        if (useMock) MockJokeCloudDataSource() else JokeCloudDataSource(
            instancesProvider.makeService(JokeService::class.java)
        )
}