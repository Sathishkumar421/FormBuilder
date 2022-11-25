package com.example.formbuilder.widgets.base

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

abstract class BaseView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {}