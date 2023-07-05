package com.example.random_joke.core.domain

import com.example.random_joke.domain.CommonItem

interface CommonInteractor<T> {

    suspend fun getItem() : CommonItem<T>
    suspend fun getItemList() : List<CommonItem<T>>
    suspend fun changeFavorites() : CommonItem<T>
    fun getFavorites(favorites: Boolean)
    suspend fun removeItem(id: T)
}