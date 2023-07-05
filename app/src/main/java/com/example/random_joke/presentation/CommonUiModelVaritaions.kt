package com.example.random_joke.presentation

import com.example.random_joke.R
import com.example.random_joke.core.presentation.Communication
import com.example.random_joke.core.presentation.FavoriteItemClickListener

class BaseCommonUiModel<E>(private val text: String, private val punchline: String) : CommonUiModel<E>(text, punchline){
    override fun getIconResId(): Int {
        return R.drawable.baseline_favorite_border_48dp
    }
}

class FavoriteCommonUiModel<E>(private val id: E, private val text: String, private val punchline: String) : CommonUiModel<E>(text, punchline){
    override fun getIconResId(): Int {
        return R.drawable.baseline_favorite_48
    }

    override fun change(listener: FavoriteItemClickListener<E>) =
        listener.change(id)

    override fun matches(id: E): Boolean = this.id == id

    override fun same(model: CommonUiModel<E>): Boolean {
        return model is FavoriteCommonUiModel<E> && model.id == id
    }

}

class FailedCommonUiModel<E>(private val text: String) : CommonUiModel<E>(text, ""){
    override fun text(): String {
        return text
    }
    override fun getIconResId(): Int {
        return 0
    }

    override fun show(communication: Communication) {
        communication.showState(State.Failed(text(), getIconResId()))
    }
}