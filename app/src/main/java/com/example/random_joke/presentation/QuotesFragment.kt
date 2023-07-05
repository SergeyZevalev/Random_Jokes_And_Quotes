package com.example.random_joke.presentation

import com.example.random_joke.JokesAndQuotesApp
import com.example.random_joke.R

class QuotesFragment : BaseFragment<QuotesViewModel, String>() {
    override fun getViewModelClass(): Class<QuotesViewModel> {
        return QuotesViewModel::class.java
    }

    override fun checkBoxText() = R.string.show_favorite_quote
    override fun actionButtonText() = R.string.get_quote
}