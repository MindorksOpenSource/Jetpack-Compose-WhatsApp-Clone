package com.mindorks.sample.whatsapp.screen.main.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _screenState = MutableLiveData(ScreenState(ScreenState.Screen.CHATS))
    var screenState: LiveData<ScreenState> = _screenState

    fun navigateTo(state: ScreenState.Screen) {
        _screenState.value = ScreenState(state)
    }
}