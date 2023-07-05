package com.example.random_joke.core.data

import com.example.random_joke.data.CommonDataModel

interface ChangeCommonItem<E> {

    suspend fun change(changeStatus: ChangeStatus<E>) : CommonDataModel<E>

    class Empty<E>() : ChangeCommonItem<E> {
        override suspend fun change(changeStatus: ChangeStatus<E>): CommonDataModel<E> {
            throw IllegalStateException("empty change joke called!")
        }

    }
}