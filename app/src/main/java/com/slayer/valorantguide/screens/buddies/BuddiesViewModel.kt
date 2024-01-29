package com.slayer.valorantguide.screens.buddies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.domain.repositories.BuddiesRepository
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.buddies.BuddyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuddiesViewModel @Inject constructor(
    private val buddiesRepository: BuddiesRepository
) : ViewModel() {
    private val _buddiesResult = mutableStateOf<List<BuddyModel>?>(null)
    val buddiesResult: State<List<BuddyModel>?> = _buddiesResult

    fun getBuddies() = viewModelScope.launch {
        when (val result = buddiesRepository.getBuddies()) {
            is NetworkResult.Error -> {}
            is NetworkResult.Exception -> {}
            is NetworkResult.Success -> {_buddiesResult.value = result.data}
        }
    }
}