package com.example.random_joke.domain

import com.example.random_joke.core.domain.FailureHandler
import com.example.random_joke.core.domain.NoCachedDataException
import com.example.random_joke.core.domain.NoConnectionException
import com.example.random_joke.core.domain.ServiceUnavailableException
import com.example.random_joke.core.domain.TestFailure
import com.example.random_joke.core.presentation.Failure
import com.example.random_joke.presentation.TestResourceManager
import java.lang.Exception

class TestFailureFactory: FailureHandler {

    private val resourceManager = TestResourceManager()

    override fun handle(e: Exception): Failure = when (e) {
        is NoConnectionException -> NoConnection(resourceManager)
        is NoCachedDataException -> NoCachedData(resourceManager)
        is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
        else -> GenericError(resourceManager)
    }
}