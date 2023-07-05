package com.example.random_joke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.example.random_joke.core.presentation.CommonCommunication

class TestCommunication<T>: CommonCommunication<T> {

    override fun observe(owner: LifecycleOwner, observer: Observer<State>) {
        TODO("Not yet implemented")
    }

    override fun showState(state: State) {
        TODO("Not yet implemented")
    }

    override fun isState(type: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getList(): List<CommonUiModel<T>> {
        TODO("Not yet implemented")
    }

    override fun getDiffResult(): DiffUtil.DiffResult {
        TODO("Not yet implemented")
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>) {
        TODO("Not yet implemented")
    }

    override fun showDataList(list: List<CommonUiModel<T>>) {
        TODO("Not yet implemented")
    }
}