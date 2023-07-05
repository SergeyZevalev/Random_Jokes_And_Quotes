package com.example.random_joke.core.presentation

interface FavoriteItemClickListener<T> {
    fun change(id: T)
}