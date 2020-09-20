package com.mindorks.sample.whatsapp.chat.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.mindorks.sample.whatsapp.data.local.chat
import com.mindorks.sample.whatsapp.data.model.User

@ExperimentalFoundationApi
@Composable
fun ChatScreenView(user: User,onBackIconClick:()->Unit) {
    Scaffold(
        bottomBar = { EditText() },
        topBar = {
            ChatTopBar(user,onBackIconClick)
        },
        bodyContent = {
            ChatsScrollView(chat.toList())
        }
    )
}