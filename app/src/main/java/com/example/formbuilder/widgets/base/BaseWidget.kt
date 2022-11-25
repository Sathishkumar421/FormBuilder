package com.example.formbuilder.widgets.base

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.formbuilder.resultRegistry.LifeCycleResultObserver
import com.example.formbuilder.data.Widget
import com.example.formbuilder.widgets.interfaces.ActivityResultInterface
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

open class BaseWidgetObserver(private val context: FragmentActivity, private val data: Widget) :
    ActivityResultInterface {

    @InstallIn(ActivityComponent::class)
    @EntryPoint
    @ActivityScoped
    interface ObserverProviderEntryPoint {
        fun observer(): LifeCycleResultObserver
    }

    override fun onActivityResult(data: Intent?) {}

    protected val observer: LifeCycleResultObserver =
        EntryPointAccessors.fromActivity(
            context,
            ObserverProviderEntryPoint::class.java
        ).observer()
}

abstract class BaseWidget(private val context: FragmentActivity, private val data: Widget) :
    BaseWidgetObserver(context, data) {
    abstract val view: BaseView
    abstract val viewModel: BaseViewModel
}

