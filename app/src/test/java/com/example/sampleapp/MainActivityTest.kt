package com.example.sampleapp

import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.LooperMode
import com.google.common.truth.Truth.assertThat
import org.robolectric.annotation.Config

@LooperMode(LooperMode.Mode.PAUSED)
@RunWith(AndroidJUnit4::class)
//@Config(sdk = [30]) // Uncomment this line to pass the tests
class MainActivityTest {
    @Test
    fun testTextView() {
        ActivityScenario.launch(MainActivity::class.java).use {
            it.onActivity { activity ->
                assertThat(activity.findViewById<TextView>(R.id.text).text).isEqualTo("test")
            }
        }
    }
}