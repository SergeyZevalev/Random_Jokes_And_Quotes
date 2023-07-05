package com.example.random_joke.core.domain

interface TestFailure {

    fun handle(e: Exception) : String
}