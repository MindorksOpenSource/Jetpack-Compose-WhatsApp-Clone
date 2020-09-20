package com.mindorks.sample.whatsapp.screen.main.view

import androidx.compose.foundation.Text
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.mindorks.sample.whatsapp.util.colorTopBar

data class ScreenState(var state: Screen = Screen.CALLS) {

    enum class Screen(
        val title: String = "Tab"
    ) {
        CALLS(title = "Calls"),
        CHATS(title = "Chats"),
        STATUS(title = "Status")
    }
}

@Composable
fun TabsPanel(
    screenState: ScreenState,
    onNavigate: (ScreenState.Screen) -> Unit,
) {
    val (selectedTab, setSelectedTab) = remember {
        mutableStateOf(
            ScreenState.Screen.values().indexOf(screenState.state)
        )
    }

    val tabs = ScreenState.Screen.values()

    TabRow(
        selectedTabIndex = selectedTab,
        backgroundColor = colorTopBar(),
        tabs = {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    text = { Text(text = tab.title.toUpperCase(), color = Color.White) },
                    selected = index == selectedTab,
                    onClick = {
                        setSelectedTab(index)
                        onNavigate(tab)
                    }
                )
            }
        }
    )
}