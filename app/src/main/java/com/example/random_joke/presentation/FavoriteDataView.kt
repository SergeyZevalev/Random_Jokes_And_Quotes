package com.example.random_joke.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.annotation.StringRes
import com.example.random_joke.R
import com.example.random_joke.core.presentation.CommonItemViewModel

class FavoriteDataView : LinearLayout {

    private lateinit var checkBox: CheckBox
    private lateinit var textView: CorrectTextView
    private lateinit var changeButton: CorrectImageButton
    private lateinit var actionButton: CorrectButton
    private lateinit var progress: CorrectProgressBar


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attr: AttributeSet){
        orientation = VERTICAL
        (context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.favorite_data_view, this, true)
        checkBox = getChildAt(0) as CheckBox
        val linear = getChildAt(1) as LinearLayout
        textView = linear.findViewById(R.id.textView)
        changeButton = linear.findViewById(R.id.changeButton)
        progress = getChildAt(2) as CorrectProgressBar
        actionButton = getChildAt(3) as CorrectButton
        progress.visibility = View.INVISIBLE

        context.theme.obtainStyledAttributes(attr, R.styleable.FavoriteDataView, 0, 0).apply{
            try {
                val actionButtonText = getString(R.styleable.FavoriteDataView_actionButtonText)
                val checkBoxText = getString(R.styleable.FavoriteDataView_checkboxText)
                checkBox.text = checkBoxText
                actionButton.text = actionButtonText
            } finally {
                recycle()
            }
        }
    }

    fun checkBoxText(@StringRes id:Int) = checkBox.setText(id)
    fun actionButtonText(@StringRes id:Int) = actionButton.setText(id)

    fun linkWith(viewModel: CommonItemViewModel) {
        actionButton.setOnClickListener {
            viewModel.getItem()
        }

        changeButton.setOnClickListener {
            viewModel.changeItemStatus()
        }

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.chooseFavorites(isChecked)
        }
    }



    fun show(state: State) = state.show(progress, actionButton, textView, changeButton)
}