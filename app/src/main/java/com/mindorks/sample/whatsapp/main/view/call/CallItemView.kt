package com.mindorks.sample.whatsapp.main.view.call

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.data.model.Call

@Composable
fun CallItem(call: Call) {
    val padding = 16.dp
    Column(Modifier.padding(padding).fillMaxWidth()) {
        Row(verticalGravity = Alignment.CenterVertically) {
            Image(
                asset = Icons.Rounded.AccountCircle,
                modifier = Modifier.gravity(align = Alignment.CenterVertically)
            )
            Column {
                Text(call.name)
                Text(call.time)
            }
        }
    }
}
