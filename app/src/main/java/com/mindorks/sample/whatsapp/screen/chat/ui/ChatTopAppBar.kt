package com.mindorks.sample.whatsapp.screen.chat.ui

import androidx.compose.foundation.Box
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.data.model.User
import com.mindorks.sample.whatsapp.util.ImageLoader
import com.mindorks.sample.whatsapp.util.colorTopBar

@Composable
fun ChatTopBar(user: User, onBackIconClick: () -> Unit) {

    Column {
        TopAppBar(
            backgroundColor = colorTopBar(),
            navigationIcon = {
                IconButton(onClick = {
                    onBackIconClick()
                }) {
                    Icon(
                        vectorResource(id = R.drawable.ic_arrow_back),
                        modifier = Modifier.padding(start = 8.dp),
                        tint = Color.White
                    )
                }
            },
            actions = {
                Box(shape = CircleShape, modifier = Modifier.size(40.dp)) {
                    ImageLoader(user.imageUrl)
                }
            },
            title = {
                Text(
                    text = user.name,
                    color = Color.White,
                    style = TextStyle(fontSize = 18.sp, textAlign = TextAlign.Center)
                )
            }
        )
    }
}