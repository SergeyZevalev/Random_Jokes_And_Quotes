package com.example.random_joke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.random_joke.core.data.cache.PersistentDataSource
import com.example.random_joke.core.presentation.NavigationCommunication

class MainViewModel(
    private val screenPosition: ScreenPosition,
    private val navigation: NavigationCommunication
) : ViewModel() {

    fun init() {
        navigateTo(screenPosition.load())
    }

    fun save(position: Int) {
        screenPosition.save(position)
        navigateTo(position)
    }

    fun observe(owner: LifecycleOwner, navigate: (Int) -> Unit) {
        navigation.observe(owner, navigate)
    }

    private fun navigateTo(position: Int) {
        navigation.navigateTo(position)
    }
}

interface ScreenPosition {
    fun save(position: Int)
    fun load(): Int

    class Base(private val persistentDataSource: PersistentDataSource) : ScreenPosition {

        override fun save(position: Int) {
            persistentDataSource.save(position, SCREEN_POSITION, KEY)
        }

        override fun load() = persistentDataSource.load(SCREEN_POSITION, KEY)

        private companion object {
            const val SCREEN_POSITION = "screenPosition"
            const val KEY = "screenPositionKey"
        }
    }
}