package com.slayer.valorantguide.screens.buddies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.buddies.BuddyModel
import com.slayer.domain.repositories.BuddiesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuddiesViewModel @Inject constructor(
    private val buddiesRepository: BuddiesRepository
) : ViewModel() {
    private val _buddiesResult = mutableStateOf<List<BuddyModel>?>(null)
    val buddiesResult: State<List<BuddyModel>?> = _buddiesResult

    private fun getBuddiesFromNetwork() = viewModelScope.launch(Dispatchers.IO) {
        when (buddiesRepository.getBuddies()) {
            is NetworkResult.Error -> {}
            is NetworkResult.Exception -> {}
            is NetworkResult.Success -> {}
        }
    }

    fun getBuddiesFromLocal() = viewModelScope.launch(Dispatchers.IO) {
        buddiesRepository.getBuddiesFromLocal().collect {
            if (it.isNotEmpty()) { _buddiesResult.value = it }
            else { getBuddiesFromNetwork() }
        }
    }
}