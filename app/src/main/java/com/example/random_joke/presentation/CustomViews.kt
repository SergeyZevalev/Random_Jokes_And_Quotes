package com.example.random_joke.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.random_joke.core.presentation.EnableView
import com.example.random_joke.core.presentation.ShowImage
import com.example.random_joke.core.presentation.ShowText
import com.example.random_joke.core.presentation.ShowView

class CorrectTextView : AppCompatTextView, ShowText {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)
    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(context, attr, defStyleAttr)
    override fun show(arg: String) {
        text = arg
    }
}

class CorrectButton : AppCompatButton, EnableView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)
    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(context, attr, defStyleAttr)

    override fun enable(enable: Boolean) {
        isEnabled = enable
    }
}

class CorrectImageButton : AppCompatImageButton, ShowImage {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)
    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    )

    override fun show(arg: Int) {
        setImageResource(arg)
    }
}

class CorrectProgressBar : ProgressBar, ShowView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)
    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(
        context,
        attr,
        defStyleAttr
    )

    override fun show(arg: Boolean) {
        visibility = if (arg) View.VISIBLE else View.INVISIBLE
    }

}