package com.example.random_joke.data.test

import com.example.random_joke.data.net.BaseCloudDataSource
import com.example.random_joke.data.net.QuoteServerModel
import okio.Timeout
import retrofit2.Call
import retrofit2.Response

class MockQuoteCloudDataSource() : BaseCloudDataSource<QuoteServerModel, String>() {

    private var id: String = "-1"
    private var idMapper:Int = -1
    override fun getServerModel(): Call<QuoteServerModel> {
            return object : SimpleCall<QuoteServerModel> {
                override fun execute(): Response<QuoteServerModel> {
                    ++idMapper
                    id = idMapper.toString()
                    return Response.success(
                        QuoteServerModel(
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