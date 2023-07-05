package com.example.random_joke.data.net

import com.example.random_joke.core.data.net.JokeService
import retrofit2.Call

class JokeCloudDataSource(private val service: JokeService) : BaseCloudDataSource<JokeServerModel, Int>(){
    override fun getServerModel(): Call<JokeServerModel> {
        return service.getJoke()
    }
}