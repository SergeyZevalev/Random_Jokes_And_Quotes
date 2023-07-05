package com.example.random_joke.data.test

import com.example.random_joke.data.net.BaseCloudDataSource
import com.example.random_joke.data.net.JokeServerModel
import okio.Timeout
import retrofit2.Call
import retrofit2.Response


class MockJokeCloudDataSource() : BaseCloudDataSource<JokeServerModel, Int>() {

    private var id: Int = -1
    override fun getServerModel(): Call<JokeServerModel> {
        return object : SimpleCall<JokeServerModel> {
            override fun execute(): Response<JokeServerModel> {
                ++id
                return Response.success(
                    JokeServerModel(
                        id,
                        "mock text $id",
                        "mock punchline $id"
                    )
                )
            }

            override fun timeout(): Timeout {
                throw IllegalStateException("timeout!")
            }
        }
    }
}