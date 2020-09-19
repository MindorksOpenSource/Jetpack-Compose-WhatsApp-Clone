package com.mindorks.sample.whatsapp.main.view.call

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import com.mindorks.sample.whatsapp.data.local.calls

@Composable
fun CallsView() {
    ScrollableColumn {
        LazyColumnFor(calls) { call ->
            CallItem(call)
        }
    }
}