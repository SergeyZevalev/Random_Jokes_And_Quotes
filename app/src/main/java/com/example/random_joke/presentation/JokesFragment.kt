package com.example.random_joke.presentation

import com.example.random_joke.R

class JokesFragment: BaseFragment<JokesViewModel, Int>() {

    override fun getViewModelClass() = JokesViewModel::class.java
    override fun checkBoxText() = R.string.show_favorite_joke
    override fun actionButtonText() = R.string.get_joke
}