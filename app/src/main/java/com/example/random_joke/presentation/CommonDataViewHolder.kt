package com.example.random_joke.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.random_joke.R
import com.example.random_joke.core.presentation.FavoriteItemClickListener

abstract class CommonDataViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
    private val textView = itemView.findViewById<CorrectTextView>(R.id.commonDataTextView)
    open fun bind(model: CommonUiModel<T>) = model.show(textView)

    class Base<T>(view: View, private val listener: FavoriteItemClickListener<T>) : CommonDataViewHolder<T>(view) {
        private val iconView = itemView.findViewById<CorrectImageButton>(R.id.removeButton)
        override fun bind(model: CommonUiModel<T>) {
            super.bind(model)
            iconView.setOnClickListener {
                model.change(listener)
            }
        }
    }
}