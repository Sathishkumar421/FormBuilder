package com.example.formbuilder.widgets.textWidget

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.formbuilder.widgets.base.BaseWidget
import com.example.formbuilder.data.Widget
import com.example.formbuilder.ui.ButtonActivity
import com.example.formbuilder.widgets.interfaces.ActivityResultInterface
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TextButtonWidget(
    private val context: FragmentActivity, private val widget: Widget
) : BaseWidget(context, widget), TextButtonInterface, ActivityResultInterface {


    ///////////////////////////////////////////////////////////////////////////
    // Views
    ///////////////////////////////////////////////////////////////////////////

    private val _view = TextButtonView(this, context)
    override val view: TextButtonView
        get() = _view

    ///////////////////////////////////////////////////////////////////////////
    // Views
    ///////////////////////////////////////////////////////////////////////////

    private val _viewModel = ViewModelProvider(
        context,
        TextButtonViewModel.BaseVMFactory<TextButtonViewModel>(widget.id)
    )[TextButtonViewModel::class.java]
    override val viewModel: TextButtonViewModel
        get() = _viewModel


    init {
        setButtonName(widget.name)
        setObservers()
    }

    private fun setButtonName(name: String) {
        view.setButtonName(name)
    }

    private fun setObservers() {
        context.lifecycle.addObserver(observer)
        context.lifecycleScope.launch {
            viewModel.buttonName.collectLatest {
                if (it.id == widget.id) {
                    val intent = Intent(context, ButtonActivity::class.java)
                    observer.setListener(this@TextButtonWidget)
                    observer.startActivity(intent)
                    setButtonName(it.name)
                }
            }
        }
    }

    override fun onClick() {
        viewModel.setButtonName(WidgetName(widget.id, "On Progress"))
    }

    override fun onActivityResult(data: Intent?) {
        setButtonName("finished, click to restart")
    }

}

interface TextButtonInterface {
    fun onClick()
}