package com.example.random_joke.core.presentation


interface Show<T> {
    fun show(arg: T)
}
interface ShowText: Show<String>

interface ShowImage: Show<Int>

interface ShowView: Show<Boolean>

interface EnableView {
    fun enable(enable: Boolean)
}