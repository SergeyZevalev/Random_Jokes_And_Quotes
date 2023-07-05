package com.example.random_joke.sl

import androidx.lifecycle.ViewModel
import com.example.random_joke.presentation.BaseViewModel


interface BaseModule<T : ViewModel> {

    fun getViewModel(): T

    abstract class Base<E, T : BaseViewModel<E>> : BaseModule<T>
}