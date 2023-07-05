package com.example.random_joke.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.random_joke.R
import com.example.random_joke.core.presentation.CommonCommunication
import com.example.random_joke.core.presentation.FavoriteItemClickListener
import com.example.random_joke.core.presentation.ListChanges
import com.example.random_joke.data.CommonDataModel

class CommonDataRecyclerAdapter<T>(
    private val listener: FavoriteItemClickListener<T>,
    private val communicator: ListChanges<T>
) :
    RecyclerView.Adapter<CommonDataViewHolder<T>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommonDataViewHolder<T> {
        val emptyList = viewType == 0
        val view = LayoutInflater.from(parent.context).inflate(
            if (emptyList) {
                R.layout.no_favorite_item
            } else {
                R.layout.common_data_item
            }, parent, false
        )
        return if (emptyList) EmptyFavoritesViewHolder(view) else CommonDataViewHolder.Base(
            view,
            listener
        )
    }

    override fun onBindViewHolder(
        holder: CommonDataViewHolder<T>,
        position: Int
    ) {
        holder.bind(communicator.getList()[position])
    }

    override fun getItemCount(): Int {
        return communicator.getList().size
    }


    inner class EmptyFavoritesViewHolder<T>(view: View) : CommonDataViewHolder<T>(view)

    override fun getItemViewType(position: Int) = when (communicator.getList()[position]) {
        is FailedCommonUiModel -> 0
        else -> 1
    }

    fun update(){
        communicator.getDiffResult().dispatchUpdatesTo(this)
    }
}