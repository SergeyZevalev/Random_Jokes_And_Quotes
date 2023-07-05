package com.example.random_joke.domain

import com.example.random_joke.core.ResourceManager
import com.example.random_joke.core.domain.FailureHandler
import com.example.random_joke.core.domain.NoCachedDataException
import com.example.random_joke.core.domain.NoConnectionException
import com.example.random_joke.core.domain.ServiceUnavailableException
import com.example.random_joke.core.presentation.Failure
import java.lang.Exception

class FailureFactory(private val resourceManager: ResourceManager) : FailureHandler {
    override fun handle(e: Exception): Failure = when (e) {
        is NoConnectionException -> NoConnection(resourceManager)
        is NoCachedDataException -> NoCachedData(resourceManager)
        is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
        else -> GenericError(resourceManager)
    }
}
