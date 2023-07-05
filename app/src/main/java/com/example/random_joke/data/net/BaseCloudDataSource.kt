package com.example.random_joke.data.net

import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.core.Mapper
import com.example.random_joke.core.data.net.CloudDataSource
import com.example.random_joke.core.domain.NoConnectionException
import com.example.random_joke.core.domain.ServiceUnavailableException
import retrofit2.Call
import java.lang.Exception
import java.net.UnknownHostException

abstract class BaseCloudDataSource<T: Mapper<CommonDataModel<E>>, E> : CloudDataSource<E> {
    protected abstract fun getServerModel() : Call<T>
    override suspend fun getData() : CommonDataModel<E> {
        try {
            return getServerModel().execute().body()!!.map()
        } catch (e: Exception) {
            if (e is UnknownHostException) throw NoConnectionException()
            else throw ServiceUnavailableException()
        }
    }
}