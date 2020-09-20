package com.mindorks.sample.whatsapp.screen.splash


import androidx.compose.foundation.Box
import androidx.compose.foundation.ContentGravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.launchInComposition
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import com.mindorks.sample.whatsapp.R
import kotlinx.coroutines.delay

private const val DELAY: Long = 2000

@Composable
fun SplashView(modifier: Modifier = Modifier, loadNextScreen: () -> Unit) {
    Surface(color = colorResource(id = R.color.whatsapp_green)) {
        Box(modifier = modifier.fillMaxSize(), gravity = ContentGravity.Center) {
            launchInComposition {
                delay(DELAY)
                loadNextScreen()
            }
            Image(asset = vectorResource(id = R.drawable.ic_whatsapp_logo))
        }
    }
}
