package com.example.random_joke.data.net

import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.core.Mapper
import com.google.gson.annotations.SerializedName

data class JokeServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("setup")
    private val text: String,
    @SerializedName("punchline")
    private val punchline: String
) : Mapper<CommonDataModel<Int>> {
    override fun map() = CommonDataModel(id, text, punchline)
}