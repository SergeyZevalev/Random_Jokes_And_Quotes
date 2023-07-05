package com.example.random_joke.presentation

import android.content.Context
import com.example.random_joke.core.ResourceManager

class BaseResourceManager(private val context: Context) : ResourceManager {
    override fun getString(stringId: Int): String {
        return context.getString(stringId)
    }
}