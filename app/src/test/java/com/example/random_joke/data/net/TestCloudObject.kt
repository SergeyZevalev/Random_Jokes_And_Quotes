package com.example.random_joke.data.net

import com.example.random_joke.core.Mapper
import com.example.random_joke.data.CommonDataModel

class TestCloudObject(
    private val id: Int
) : Mapper<CommonDataModel<Int>> {
    override fun map(): CommonDataModel<Int> {
        return CommonDataModel(id, "test text $id", "test punchline $id")
    }
}