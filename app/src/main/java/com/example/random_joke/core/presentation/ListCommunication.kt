package com.example.random_joke.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.example.random_joke.presentation.CommonUiModel

interface ListCommunication<T> : ListChanges<T> {
    fun showDataList(list: List<CommonUiModel<T>>)
    fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>)
}

interface ListChanges<T> {
    fun getList(): List<CommonUiModel<T>>
    fun getDiffResult(): DiffUtil.DiffResult
}