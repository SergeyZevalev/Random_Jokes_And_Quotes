package com.example.random_joke.domain

import com.example.random_joke.core.data.CommonDataModelMapper
import com.example.random_joke.core.data.CommonRepository
import com.example.random_joke.core.domain.CommonInteractor
import com.example.random_joke.core.domain.FailureHandler
import com.example.random_joke.domain.CommonItem
import java.lang.Exception

class BaseInteractor<E>(
    private val repository: CommonRepository<E>,
    private val failureHandler: FailureHandler,
    private val mapper: CommonDataModelMapper<CommonItem.Success<E>, E>
) : CommonInteractor<E> {
    override suspend fun getItem(): CommonItem<E> {
        return try {
            repository.getCommonItem().map(mapper)
        } catch (e: Exception) {
            CommonItem.Failed(failureHandler.handle(e))
        }
    }

    override suspend fun getItemList(): List<CommonItem<E>> {
        return try {
            repository.getCommonItemList().map {
                it.map(mapper)
            }
        } catch (e: Exception) {
            listOf(CommonItem.Failed(failureHandler.handle(e)))
        }
    }

    override suspend fun changeFavorites(): CommonItem<E> {
        return try {
            repository.changeStatus().map(mapper)
        } catch (e: Exception) {
            CommonItem.Failed(failureHandler.handle(e))
        }
    }

    override fun getFavorites(favorites: Boolean) {
        repository.chooseDataSource(favorites)
    }

    override suspend fun removeItem(id: E) {
        repository.removeItem(id)
    }
}