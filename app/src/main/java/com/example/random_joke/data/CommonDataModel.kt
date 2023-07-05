package com.example.random_joke.data

import com.example.random_joke.core.data.ChangeCommonItem
import com.example.random_joke.core.data.ChangeStatus
import com.example.random_joke.core.data.CommonDataModelMapper
import com.example.random_joke.core.presentation.ShowText


class CommonDataModel<E>(
    private val id: E,
    private val firstText: String,
    private val secondText: String,
    private val cached: Boolean = false
) : ChangeCommonItem<E> {

    fun map(showText: ShowText) = showText.show(firstText)

    fun <T> map(mapper: CommonDataModelMapper<T, E>): T {
        return mapper.map(id, firstText, secondText, cached)
    }
    override suspend fun change(changeStatus: ChangeStatus<E>) = changeStatus.addOrRemoveIt(id, this)

    fun changeCached(cached: Boolean) : CommonDataModel<E> {
        return CommonDataModel(id, firstText, secondText, cached)
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31*result + firstText.hashCode()
        result = 31*result + secondText.hashCode()
        result = 31*result + cached.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CommonDataModel<E>
        if (id != other.id) return false
        if (firstText != other.firstText) return false
        if (secondText != other.secondText) return false
        if (cached != other.cached) return false
        return true
    }

}