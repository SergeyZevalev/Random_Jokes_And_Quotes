package com.example.random_joke.sl

import com.example.random_joke.core.presentation.NavigationCommunication
import com.example.random_joke.presentation.MainViewModel
import com.example.random_joke.presentation.ScreenPosition

class MainModule(private val commonInstancesProvider: CommonInstancesProvider) :
    BaseModule<MainViewModel> {
    override fun getViewModel() = MainViewModel(
        ScreenPosition.Base(commonInstancesProvider.providePersistentDataSource()),
        NavigationCommunication.Base()
    )
}