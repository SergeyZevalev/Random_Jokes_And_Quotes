package com.example.random_joke.presentation

import com.example.random_joke.core.domain.CommonInteractor
import com.example.random_joke.core.presentation.CommonCommunication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TestViewModel(
    interactor: CommonInteractor<Int>,
    communication: CommonCommunication<Int>,
    dispatcher: CoroutineDispatcher = Dispatchers.Unconfined
) : BaseViewModel<Int>(interactor, communication, dispatcher) {
}