package com.example.random_joke.core.data.net

import com.example.random_joke.data.net.QuoteServerModel
import retrofit2.Call
import retrofit2.http.GET

interface QuoteService {

    @GET("http://api.quotable.io/random")
    fun getQuote(): Call<QuoteServerModel>
}