package com.example.random_joke.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.random_joke.core.domain.CommonInteractor
import com.example.random_joke.core.presentation.CommonCommunication
import com.example.random_joke.core.presentation.CommonViewModel
import com.example.random_joke.core.presentation.ListChanges
import com.example.random_joke.domain.CommonItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel<T>(
    private val interactor: CommonInteractor<T>,
    private val communication: CommonCommunication<T>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), CommonViewModel<T>, ListChanges<T> {

    override fun getList() = communication.getList()
    override fun getDiffResult() = communication.getDiffResult()

    override fun getItem() {
        viewModelScope.launch(dispatcher) {
            communication.showState(State.Progress)
            interactor.getItem().map().show(communication)
        }
    }

    override fun getItemList() {
        viewModelScope.launch(dispatcher) {
            showList()
        }
    }

    override fun changeItemStatus(id: T) {
        viewModelScope.launch(dispatcher) {
            interactor.removeItem(id)
            showList()
        }
    }

    private suspend fun showList() = communication.showDataList(interactor.getItemList().toUiList())

    override fun chooseFavorites(cached: Boolean) =
        interactor.getFavorites(cached)


    override fun observe(owner: LifecycleOwner, observer: Observer<State>) =
        communication.observe(owner, observer)


    override fun changeItemStatus() {
        viewModelScope.launch(dispatcher) {
            if (communication.isState(State.INITIAL)) {
                interactor.changeFavorites().map().show(communication)
                showList()
            }
        }
    }

    override fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>) {
        communication.observeList(owner, observer)
    }
}

fun <T> List<CommonItem<T>>.toUiList() = map { it.map() }