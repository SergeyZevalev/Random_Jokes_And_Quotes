package com.example.random_joke.presentation

import com.example.random_joke.core.domain.CommonInteractor
import com.example.random_joke.core.presentation.CommonCommunication

class QuotesViewModel(
    interactor: CommonInteractor<String>,
    communication: CommonCommunication<String>,
) : BaseViewModel<String>(interactor, communication) {
}