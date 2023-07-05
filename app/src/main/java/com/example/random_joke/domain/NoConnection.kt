package com.example.random_joke.domain

import com.example.random_joke.R
import com.example.random_joke.core.ResourceManager
import com.example.random_joke.presentation.BaseFailure

class NoConnection(private val resourceManager: ResourceManager) : BaseFailure(resourceManager) {
    override fun getMessageId() = R.string.no_connection

}