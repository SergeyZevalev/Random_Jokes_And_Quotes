package com.example.random_joke.data.test

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback

interface SimpleCall<T> : Call<T> {

    override fun clone(): Call<T> {
        throw IllegalStateException("not used")
    }

    override fun enqueue(callback: Callback<T>) {
        return Unit
    }

    override fun isExecuted(): Boolean {
        return false
    }

    override fun cancel() {
        return Unit
    }

    override fun isCanceled(): Boolean {
        return false
    }

    override fun request(): Request {
        throw IllegalStateException("not used")
    }
}