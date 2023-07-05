package com.example.random_joke.core.data

import com.example.random_joke.data.CommonDataModel


interface ChangeStatus<E> {

    suspend fun addOrRemoveIt(id: E, model: CommonDataModel<E>) : CommonDataModel<E>
}