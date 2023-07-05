package com.example.random_joke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import com.example.random_joke.core.presentation.CommonCommunication

class BaseCommunication<T> : CommonCommunication<T> {

    private val liveData = MutableLiveData<State>()
    private val liveDataList = MutableLiveData<ArrayList<CommonUiModel<T>>>()

    private lateinit var diffResult: DiffUtil.DiffResult

    override fun getDiffResult() = diffResult

    override fun observe(owner: LifecycleOwner, observer: Observer<State>) {
        liveData.observe(owner, observer)
    }

    override fun showState(state: State) {
        liveData.value = state
    }

    override fun showDataList(list: List<CommonUiModel<T>>) {
        val callback = CommonDiffUtilCallback(liveDataList.value ?: emptyList(), list)
        diffResult = DiffUtil.calculateDiff(callback)
        liveDataList.value = ArrayList(list)
    }

    override fun isState(type: Int) = liveData.value?.isType(type) ?: false
    override fun getList(): List<CommonUiModel<T>> {
        return liveDataList.value?: emptyList()
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>) {
        liveDataList.observe(owner, observer)
    }

}