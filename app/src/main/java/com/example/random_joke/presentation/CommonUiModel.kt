package com.example.random_joke.presentation

import androidx.annotation.DrawableRes
import com.example.random_joke.core.presentation.Communication
import com.example.random_joke.core.presentation.FavoriteItemClickListener
import com.example.random_joke.core.presentation.ShowText

abstract class CommonUiModel<T>(private val first: String, private val second: String) {

    protected open fun text() = "$first\n$second"

    @DrawableRes
    protected abstract fun getIconResId(): Int

    open fun same(model: CommonUiModel<T>) : Boolean = false

    open fun show(communication: Communication) = communication.showState(
        State.Initial(
            text(),
            getIconResId()
        )
    )
    fun show (showText: ShowText) = showText.show(text())

    open fun change(listener: FavoriteItemClickListener<T>) = Unit
    open fun matches(id: T): Boolean = false

}