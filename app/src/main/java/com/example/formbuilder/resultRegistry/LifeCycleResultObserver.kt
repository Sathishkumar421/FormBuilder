package com.example.formbuilder.resultRegistry

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.formbuilder.widgets.interfaces.ActivityResultInterface

class LifeCycleResultObserver(
    private val registry: ActivityResultRegistry
) :
    DefaultLifecycleObserver {

    lateinit var getContent: ActivityResultLauncher<Intent>

    private var listener: ActivityResultInterface? = null

    override fun onCreate(owner: LifecycleOwner) {
        getContent = registry.register(
            "key",
            owner,
            ActivityResultContracts.StartActivityForResult()
        ) { it ->
            if (it.resultCode == Activity.RESULT_OK) {
               listener?.onActivityResult(it.data)
            }
        }
    }

    fun setListener(listener: ActivityResultInterface) {
        this.listener = listener
    }

    fun startActivity(intent: Intent) {
        getContent.launch(intent)
    }
}