package com.example.random_joke.core.data

interface CommonDataModelMapper<T, E> {

    fun map(id: E, first: String, second: String, cached: Boolean) : T
}