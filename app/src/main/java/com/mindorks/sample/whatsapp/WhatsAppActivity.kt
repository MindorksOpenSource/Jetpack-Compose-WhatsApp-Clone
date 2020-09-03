package com.mindorks.sample.whatsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.mindorks.sample.whatsapp.splash.SplashView
import com.mindorks.sample.whatsapp.ui.WhatsAppTheme

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


