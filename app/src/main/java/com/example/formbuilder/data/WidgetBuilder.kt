package com.example.formbuilder.data

import androidx.fragment.app.FragmentActivity
import com.example.formbuilder.widgets.base.BaseWidget
import com.example.formbuilder.util.Constants
import com.example.formbuilder.widgets.textWidget.TextButtonWidget
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class WidgetBuilder @Inject constructor() {

    @Inject
    lateinit var context: FragmentActivity

    var widgets: MutableList<BaseWidget> = mutableListOf()

    fun getFormWidgets(list: MutableList<Widget>): MutableList<BaseWidget> {
        list.forEach {
            when (it.type) {
                Constants.WidgetType.TEXT -> {
                    widgets.add(TextButtonWidget(context, it))
                }
            }
        }
        return widgets
    }

}