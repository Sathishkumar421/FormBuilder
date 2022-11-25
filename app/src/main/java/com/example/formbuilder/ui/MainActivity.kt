package com.example.formbuilder.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.formbuilder.data.WidgetBuilder
import com.example.formbuilder.data.Widget
import com.example.formbuilder.databinding.ActivityMainBinding
import com.example.formbuilder.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var widgetBuilder: WidgetBuilder

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var parentLl: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        viewBinding.apply {
            parentLl = parentLayout
        }
        setContentView(viewBinding.root)


        val textWidget1 = Widget(1L, Constants.WidgetType.TEXT, "Start Task 1")
        val textWidget2 = Widget(2L, Constants.WidgetType.TEXT, "Start Task 2")
        val textWidget3 = Widget(3L, Constants.WidgetType.TEXT, "Start Task 3")

        val widgets = widgetBuilder.getFormWidgets(
            mutableListOf<Widget>(
                textWidget1, textWidget2, textWidget3
            )
        )

        widgets.forEach {
            parentLl.addView(it.view)
        }
    }

}