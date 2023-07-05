package com.example.random_joke.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.random_joke.presentation.CommonUiModel
import com.example.random_joke.presentation.State

interface Communication {

    fun observe(owner: LifecycleOwner, observer: Observer<State>)
    fun showState(state: State)
    fun isState(type: Int) : Boolean
}