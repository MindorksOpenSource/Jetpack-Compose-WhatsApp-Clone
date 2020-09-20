package com.mindorks.sample.whatsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.ui.tooling.preview.Preview
import com.mindorks.sample.whatsapp.screen.splash.SplashView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whatsapp)
       
    }

    @Preview
    @Composable
    fun previewSplash() {
        Surface {
            SplashView {

            }
        }
    }
}


