package com.mindorks.sample.whatsapp.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.mindorks.sample.whatsapp.main.util.TabScreen
import com.mindorks.sample.whatsapp.main.view.ScreenState
import com.mindorks.sample.whatsapp.main.view.TabsPanel
import com.mindorks.sample.whatsapp.main.view.call.CallsView
import com.mindorks.sample.whatsapp.ui.WhatsAppTheme

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