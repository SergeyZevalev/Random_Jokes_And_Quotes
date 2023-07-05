package com.example.random_joke.core.data.net

import com.example.random_joke.data.net.JokeServerModel
import retrofit2.Call
import retrofit2.http.GET

interface JokeService  {

    @GET("https://official-joke-api.appspot.com/random_joke")
    fun getJoke(): Call<JokeServerModel>

}

