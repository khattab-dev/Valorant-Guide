package com.slayer.valorantguide.screens.sprays

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.common.printToLog
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.sprays.SprayModel
import com.slayer.domain.repositories.SpraysRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpraysViewModel @Inject constructor(
    private val spraysRepository: SpraysRepository
) : ViewModel() {
    private val _spraysValue = mutableStateOf<List<SprayModel>?>(null)
    val spraysValue: State<List<SprayModel>?> = _spraysValue

    private fun getSpraysFromNetwork() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = spraysRepository.getSpraysFromNetwork()) {
            is NetworkResult.Error -> {
                result.errorMsg.printToLog()
            }
            is NetworkResult.Exception -> {
                result.e.stackTraceToString().printToLog()
            }

            is NetworkResult.Success -> {}
        }
    }

    fun getSpraysFromLocal() = viewModelScope.launch(Dispatchers.IO) {
        spraysRepository.getSpraysFromLocal().collect {
            if (it.isNotEmpty()) { _spraysValue.value = it }
            else { getSpraysFromNetwork() }
        }
    }
}