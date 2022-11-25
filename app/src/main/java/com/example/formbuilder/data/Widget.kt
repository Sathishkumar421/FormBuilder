package com.example.formbuilder.data

import android.os.Parcelable
import com.example.formbuilder.util.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class Widget(
    val id: Long = -1,
    val type: Constants.WidgetType = Constants.WidgetType.TEXT,
    val name: String = ""
) : Parcelable {}
