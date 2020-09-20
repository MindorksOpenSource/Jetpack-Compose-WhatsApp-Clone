package com.mindorks.sample.whatsapp.screen.main.view.chats

import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.sample.whatsapp.data.model.Chat
import com.mindorks.sample.whatsapp.data.model.User
import com.mindorks.sample.whatsapp.util.ImageLoader
import com.mindorks.sample.whatsapp.util.colorGreen
import com.mindorks.sample.whatsapp.util.colorLightGreen

@Composable
fun ChatsItemView(chat: Chat, loadNextScreen: (User) -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().clickable {
            loadNextScreen(
                User(
                    id = 2,
                    chat.name,
                    chat.url
                )
            )
        } + Modifier.padding(top = 4.dp, bottom = 4.dp)) {
        Row(modifier = Modifier.padding(10.dp)) {
            Box(shape = CircleShape, modifier = Modifier.size(40.dp)) {
                ImageLoader(chat.url)
            }
            Spacer(modifier = Modifier.preferredSize(12.dp))
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(chat.name)
                Spacer(modifier = Modifier.preferredSize(2.dp))
                userChat(chat)
            }
            Column(modifier = Modifier.weight(1.0f, true), horizontalGravity = Alignment.End) {
                MessageTime(chat)
                Spacer(modifier = Modifier.preferredSize(2.dp))
                unreadCount(chat)
            }
        }
    }
}

@Composable
fun userChat(chat: Chat) {

    Text(
        text = chat.chat,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Gray
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
fun MessageTime(chat: Chat) {

    Text(
        text = chat.time,
        style = TextStyle(
            fontSize = 12.sp,
            color = colorGreen()
        )
    )
}

@Composable
fun unreadCount(chat: Chat) {

    if (chat.unreadCount != "0") {
        setupUnreadCount(chat.unreadCount)
    }
}

@Composable
fun setupUnreadCount(count: String) {

    Column(horizontalGravity = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.preferredSize(20.dp),
            backgroundColor = colorGreen(),
            gravity = Alignment.Center,
            shape = CircleShape
        ) {
            Text(
                text = count,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = colorLightGreen()
                )
            )
        }
    }
}