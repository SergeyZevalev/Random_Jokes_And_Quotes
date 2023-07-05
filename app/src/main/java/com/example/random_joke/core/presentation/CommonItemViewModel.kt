package com.example.random_joke.core.presentation

interface CommonItemViewModel {

    fun getItem()
    fun getItemList()
    fun changeItemStatus()
    fun chooseFavorites(cached: Boolean)
}