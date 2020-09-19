package com.mindorks.sample.whatsapp.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.mindorks.sample.whatsapp.main.view.ScreenState
import com.mindorks.sample.whatsapp.main.view.TabsPanel
import com.mindorks.sample.whatsapp.main.view.call.CallsView
import com.mindorks.sample.whatsapp.ui.WhatsAppTheme
import com.mindorks.sample.whatsapp.util.colorTopBar

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {

            setContent {
                WhatsAppTheme {
                    onScreenSelected(
                        ScreenState(ScreenState.Screen.CALLS)
                    ) {
                        //ViewModel for navigation
                    }

                }
            }
        }
    }

    @Composable
    private fun onScreenSelected(
        screenState: ScreenState,
        onNavigate: (ScreenState.Screen) -> Unit
    ) {
        Column {
            TopAppBar(title = { Text("WhatsApp",color = Color.White)}, backgroundColor = colorTopBar(),elevation = 0.dp)
            TabsPanel(screenState, onNavigate)
            Surface {
                when (screenState.state) {
                    ScreenState.Screen.CALLS -> {
                        CallsView()
                    }
                    ScreenState.Screen.CHATS -> {

                    }
                    ScreenState.Screen.STATUS -> {

                    }
                }
            }
        }
    }
}