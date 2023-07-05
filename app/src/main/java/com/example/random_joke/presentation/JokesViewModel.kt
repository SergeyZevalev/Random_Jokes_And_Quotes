package com.example.random_joke.presentation

import com.example.random_joke.core.domain.CommonInteractor
import com.example.random_joke.core.presentation.CommonCommunication

class JokesViewModel(
    interactor: CommonInteractor<Int>,
    communication: CommonCommunication<Int>,
) : BaseViewModel<Int>(interactor, communication){
}