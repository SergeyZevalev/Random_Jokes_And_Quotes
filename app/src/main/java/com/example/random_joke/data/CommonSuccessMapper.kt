package com.example.random_joke.data

import com.example.random_joke.core.data.CommonDataModelMapper
import com.example.random_joke.domain.CommonItem

class CommonSuccessMapper<E> : CommonDataModelMapper<CommonItem.Success<E>, E> {
    override fun map(id: E, first: String, second: String, cached: Boolean): CommonItem.Success<E> {
        return CommonItem.Success(id, first, second, cached)
    }
}