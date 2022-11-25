package com.example.formbuilder.widgets.textWidget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.formbuilder.widgets.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class TextButtonViewModel(val widgetId: Long) : BaseViewModel(widgetId) {

    private var _buttonName = MutableSharedFlow<WidgetName>(0)
    val buttonName: SharedFlow<WidgetName> = _buttonName.asSharedFlow()

    fun setButtonName(widgetName: WidgetName) {
        viewModelScope.launch {
            _buttonName.emit(widgetName)
        }
    }

    class BaseVMFactory<T : BaseViewModel>(
        private val widgetId: Long
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TextButtonViewModel(widgetId) as T
        }
    }
}

data class WidgetName(
    val id: Long = -1L,
    val name: String = ""
)