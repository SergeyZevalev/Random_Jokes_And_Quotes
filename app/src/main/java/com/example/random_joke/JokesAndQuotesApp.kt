package com.example.random_joke

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.random_joke.sl.CoreModule
import com.example.random_joke.sl.JokesModule
import com.example.random_joke.sl.MainModule
import com.example.random_joke.sl.QuotesModule
import com.example.random_joke.sl.ViewModelFactory
import io.realm.BuildConfig

class JokesAndQuotesApp : Application() {

    private val viewModelsFactory by lazy {
        ViewModelFactory(MainModule(coreModule), JokesModule(coreModule, useMock), QuotesModule(coreModule))
    }

    private lateinit var coreModule: CoreModule
    private val useMock = false

    override fun onCreate() {
        super.onCreate()

        coreModule = CoreModule(this, useMock)
    }

    fun <T : ViewModel> get(modelClass: Class<T>, owner: ViewModelStoreOwner): T =
        ViewModelProvider(owner, viewModelsFactory).get(modelClass)
}