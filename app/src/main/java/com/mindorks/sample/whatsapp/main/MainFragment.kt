package com.mindorks.sample.whatsapp.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.main.view.MainViewModel
import com.mindorks.sample.whatsapp.main.view.ScreenState
import com.mindorks.sample.whatsapp.main.view.TabsPanel
import com.mindorks.sample.whatsapp.main.view.call.CallsView
import com.mindorks.sample.whatsapp.ui.WhatsAppTheme
import com.mindorks.sample.whatsapp.util.colorTopBar

class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

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
                        viewModel.navigateTo(it)
                    }

                }
            }
        }
    }

    @Composable
    private fun onScreenSelected(
        initialScreenState: ScreenState,
        onNavigate: (ScreenState.Screen) -> Unit
    ) {
        val screenState: State<ScreenState?> = viewModel.screenState.observeAsState(viewModel.screenState.value)

        Column {
            TopAppBar(
                title = { Text(getString(R.string.whatsapp), color = Color.White) },
                backgroundColor = colorTopBar(),
                elevation = 0.dp
            )
            TabsPanel(screenState.value ?: initialScreenState, onNavigate)
            Surface {
                when (screenState.value?.state) {
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