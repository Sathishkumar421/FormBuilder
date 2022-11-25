package com.example.formbuilder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formbuilder.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityButtonBinding.inflate(layoutInflater)
        viewBinding.goBackTv.setOnClickListener {
            finish()
        }
        viewBinding.finishTv.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
        setContentView(viewBinding.root)
    }
}