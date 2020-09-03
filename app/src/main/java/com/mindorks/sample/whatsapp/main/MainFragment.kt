package com.mindorks.sample.whatsapp.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.mindorks.sample.whatsapp.main.util.TabScreen
import com.mindorks.sample.whatsapp.main.view.MainTabs
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
                    var tabSelected =  remember { mutableStateOf(TabScreen.Chat) }

                    MainTabs(titles = TabScreen.values().map { it.name }, tabSelected = TabScreen.Chat , onTabSelected = {
                        tabSelected.value = TabScreen.values()[it.ordinal]

                    })
                }
            }
        }
    }
}