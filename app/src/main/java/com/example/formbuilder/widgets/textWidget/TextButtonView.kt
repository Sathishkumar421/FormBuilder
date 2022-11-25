package com.example.formbuilder.widgets.textWidget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.example.formbuilder.R
import com.example.formbuilder.widgets.base.BaseView

class TextButtonView(
    listener: TextButtonInterface?,
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseView(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : this(
        null,
        context
    )

    private lateinit var textTv: TextView

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TextButtonView,
            0, 0
        ).apply {
            try {
                val cardView = LayoutInflater.from(context).inflate(
                    R.layout.layout_text_button,
                    this@TextButtonView,
                    true
                )

                textTv = cardView.findViewById(R.id.text_tv)
                textTv.setOnClickListener {
                    listener?.onClick()
                }
            } finally {
                invalidate()
                requestLayout()
                recycle()
            }

        }
    }


    fun setButtonName(name: String) {
        textTv.text = name
    }

}