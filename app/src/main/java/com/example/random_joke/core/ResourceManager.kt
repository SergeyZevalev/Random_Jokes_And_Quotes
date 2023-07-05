package com.example.random_joke.core

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringId: Int) : String
}