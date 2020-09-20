package com.mindorks.sample.whatsapp.screen.main

import android.os.Bundle
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
import androidx.navigation.fragment.findNavController
import com.mindorks.sample.whatsapp.R
import com.mindorks.sample.whatsapp.screen.main.view.MainViewModel
import com.mindorks.sample.whatsapp.screen.main.view.ScreenState
import com.mindorks.sample.whatsapp.screen.main.view.TabsPanel
import com.mindorks.sample.whatsapp.screen.main.view.call.CallsView
import com.mindorks.sample.whatsapp.screen.main.view.chats.ChatsView
import com.mindorks.sample.whatsapp.screen.main.view.status.StatusView
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
                    onScreenSelected {
                        viewModel.navigateTo(it)
                    }
                }
            }
        }
    }

    @Composable
    private fun onScreenSelected(onNavigate: (ScreenState.Screen) -> Unit) {

        val screenState: State<ScreenState?> =
            viewModel.screenState.observeAsState(viewModel.screenState.value)

        Column {
            TopAppBar(
                title = { Text(getString(R.string.whatsapp), color = Color.White) },
                backgroundColor = colorTopBar(),
                elevation = 0.dp
            )
            screenState.value?.let { TabsPanel(it, onNavigate) }
            Surface {
                when (screenState.value?.state) {

                    ScreenState.Screen.CALLS -> CallsView()

                    ScreenState.Screen.CHATS -> ChatsView {
                        val action = MainFragmentDirections.actionMainFragmentToChatFragment(
                            it.name,
                            it.imageUrl
                        )
                        findNavController().navigate(action)
                    }

                    ScreenState.Screen.STATUS -> StatusView()
                }
            }
        }
    }
}