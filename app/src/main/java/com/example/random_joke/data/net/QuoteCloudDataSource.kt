package com.example.random_joke.data.net

import com.example.random_joke.core.data.net.QuoteService
import retrofit2.Call

class QuoteCloudDataSource(private val service: QuoteService) : BaseCloudDataSource<QuoteServerModel, String>() {
    override fun getServerModel(): Call<QuoteServerModel> {
        return service.getQuote()
    }
}