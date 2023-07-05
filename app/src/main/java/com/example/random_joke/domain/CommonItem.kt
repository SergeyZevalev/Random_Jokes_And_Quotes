package com.example.random_joke.domain

import com.example.random_joke.presentation.BaseCommonUiModel
import com.example.random_joke.presentation.FailedCommonUiModel
import com.example.random_joke.presentation.FavoriteCommonUiModel
import com.example.random_joke.core.presentation.Failure
import com.example.random_joke.presentation.CommonUiModel
import com.example.random_joke.core.Mapper

sealed class CommonItem<E> : Mapper<CommonUiModel<E>> {

    class Success<E>(
        private val id: E,
        private val text: String,
        private val punchline: String,
        private val favorite: Boolean
    ) : CommonItem<E>() {
        override fun map() =
            if (favorite) {
                FavoriteCommonUiModel(id, text, punchline)
            } else {
                BaseCommonUiModel(text, punchline)
            }
    }

    class Failed<E>(private val failure: Failure) : CommonItem<E>() {
        override fun map(): CommonUiModel<E> {
            return FailedCommonUiModel(failure.getErrorMessage())
        }

    }
}


