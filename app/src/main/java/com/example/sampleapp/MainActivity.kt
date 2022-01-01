package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sample_lib.CommonFont

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateTextView()
    }

    fun updateTextView() {
        findViewById<TextView>(R.id.text).apply {
            text = "test"
            typeface = CommonFont.getFont(this@MainActivity)
        }
    }
}