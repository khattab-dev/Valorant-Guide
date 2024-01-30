package com.slayer.valorantguide.screens.maps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.maps.MapModel
import com.slayer.domain.repositories.MapsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val mapsRepository: MapsRepository
) : ViewModel() {
    private val _mapsResult = mutableStateOf<List<MapModel>?>(null)
    val mapsResult: State<List<MapModel>?> = _mapsResult

    private fun getMapsNetwork() = viewModelScope.launch(Dispatchers.IO) {
        when (mapsRepository.getMapsFromNetwork()) {
            is NetworkResult.Error -> {}
            is NetworkResult.Exception -> {}
            is NetworkResult.Success -> {}
        }
    }

    fun getMapsFromLocal() = viewModelScope.launch(Dispatchers.IO) {
        mapsRepository.getMapsFromLocal().collect {
            if (it.isNotEmpty()) { _mapsResult.value = it }
            else { getMapsNetwork() }
        }
    }
}