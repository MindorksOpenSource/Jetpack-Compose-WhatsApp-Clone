package com.mindorks.sample.whatsapp.main.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    private var _screenState = MutableLiveData(ScreenState())
    var screenState: LiveData<ScreenState> = _screenState

    fun navigateTo(state: ScreenState.Screen) {
        _screenState.value = ScreenState(state)
    }
}