package com.mindorks.sample.whatsapp.screen.chat.ui

import androidx.compose.foundation.BaseTextField
import androidx.compose.foundation.Box
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.util.ImageLoader
import com.mindorks.sample.whatsapp.util.colorTopBar

@ExperimentalFoundationApi
@Composable
fun EditText(onMessageSend: (String) -> Unit) {

    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()

    Box(backgroundColor = colorTopBar()) {
        Row(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
            BaseTextField(
                value = textState.value,
                modifier = Modifier.weight(1f, true),
                onValueChange = {
                    textState.value = it
                })
            Spacer(modifier = Modifier.preferredSize(12.dp))

            ImageLoader(
                imageUrl = R.drawable.ic_send,
                modifier = Modifier.weight(0.05f, true),
                onClick = {

                    onMessageSend(textState.value.text)
                    scrollState.smoothScrollTo(0f)
                })
        }
    }
}