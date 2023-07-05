package com.example.random_joke.presentation

import androidx.annotation.StringRes
import com.example.random_joke.core.ResourceManager
import com.example.random_joke.core.presentation.Failure

abstract class BaseFailure(private val resourceManager: ResourceManager) : Failure {
    @StringRes
    protected abstract fun getMessageId() : Int
    override fun getErrorMessage() = resourceManager.getString(getMessageId())
}