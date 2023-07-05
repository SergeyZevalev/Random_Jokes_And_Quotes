package com.example.random_joke.sl

import android.content.Context
import com.example.random_joke.core.data.cache.PersistentDataSource
import com.example.random_joke.core.data.cache.RealmProvider
import com.example.random_joke.core.domain.FailureHandler
import com.example.random_joke.data.cache.BaseRealmProvider
import com.example.random_joke.domain.FailureFactory
import com.example.random_joke.presentation.BaseResourceManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoreModule(context: Context, useMock: Boolean) : CommonInstancesProvider {

    private val realmProvider by lazy { BaseRealmProvider(context, useMock) }
    private val persistentDataStore by lazy { PersistentDataSource.Base(context) }
    private val failureHandler by lazy { FailureFactory(BaseResourceManager(context)) }
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.google.com")
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun <T> makeService(service: Class<T>): T = retrofit.create(service)
    override fun provide() = realmProvider.provide()
    override fun providePersistentDataSource() = persistentDataStore
    override fun provideFailureHandler() = failureHandler
}

interface CommonInstancesProvider : RealmProvider {
    fun <T> makeService(service: Class<T>): T
    fun providePersistentDataSource(): PersistentDataSource
    fun provideFailureHandler(): FailureHandler
}