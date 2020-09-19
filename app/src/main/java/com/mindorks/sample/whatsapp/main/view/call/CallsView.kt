package com.mindorks.sample.whatsapp.main.view.call

import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import com.mindorks.sample.whatsapp.data.local.calls

@Composable
fun CallsView() {
    LazyColumnFor(calls) { call ->
        CallItem(call)

    }
}