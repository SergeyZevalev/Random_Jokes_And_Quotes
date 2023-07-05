package com.example.random_joke.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.random_joke.presentation.CommonUiModel
import com.example.random_joke.presentation.State

interface CommonViewModel<T> : CommonItemViewModel {

    fun changeItemStatus(id: T)
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
    fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>)
}