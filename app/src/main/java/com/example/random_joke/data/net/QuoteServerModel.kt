package com.example.random_joke.data.net

import com.example.random_joke.data.CommonDataModel
import com.example.random_joke.core.Mapper
import com.google.gson.annotations.SerializedName

class QuoteServerModel(
    @SerializedName("id")
    private val id: String,
    @SerializedName("content")
    private val content: String,
    @SerializedName("author")
    private val author: String
) : Mapper<CommonDataModel<String>> {
    override fun map() = CommonDataModel(id, content, author)

}