package com.mindorks.sample.whatsapp.screen.main.view.status

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mindorks.sample.whatsapp.data.local.statusList
import com.mindorks.sample.whatsapp.util.colorLightGreen

@Composable
fun StatusView() {
    LazyColumnFor(statusList, modifier = Modifier.background(color = colorLightGreen())) { status ->
        StatusItemView(status)
        Divider()
    }
}