package com.example.random_joke.core.domain

import com.example.random_joke.core.presentation.Failure
import java.lang.Exception

interface FailureHandler {

    fun handle(e: Exception) : Failure
}