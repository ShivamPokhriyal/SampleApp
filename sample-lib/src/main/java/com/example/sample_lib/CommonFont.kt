package com.example.sample_lib

import android.content.Context
import androidx.core.content.res.ResourcesCompat

object CommonFont {
    fun getFont(context: Context) = ResourcesCompat.getFont(context, R.font.bogle)
}