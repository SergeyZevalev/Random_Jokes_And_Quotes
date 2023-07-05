package com.example.random_joke.sl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.random_joke.presentation.JokesViewModel
import com.example.random_joke.presentation.MainViewModel
import com.example.random_joke.presentation.QuotesViewModel

class ViewModelFactory(
    private val mainModule: MainModule,
    private val jokesModule: JokesModule,
    private val quotesModule: QuotesModule
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val model = when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> mainModule
            modelClass.isAssignableFrom(JokesViewModel::class.java) -> jokesModule
            modelClass.isAssignableFrom(QuotesViewModel::class.java) -> quotesModule
            else -> throw IllegalStateException("unknown type of viewModel")
        }
        return model.getViewModel() as T
    }
}