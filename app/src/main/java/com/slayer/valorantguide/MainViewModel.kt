package com.slayer.valorantguide

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _appBarTitle = mutableStateOf("VALORANT GUIDE")
    val appBarTitle: State<String> = _appBarTitle

    fun setTitle(title : String?) {
        _appBarTitle.value = title ?: "VALORANT GUIDE"
    }
}