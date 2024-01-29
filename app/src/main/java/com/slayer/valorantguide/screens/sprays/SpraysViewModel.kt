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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpraysViewModel @Inject constructor(
    private val spraysRepository: SpraysRepository
) : ViewModel() {
    private val _spraysValue = mutableStateOf<List<SprayModel>?>(null)
    val spraysValue: State<List<SprayModel>?> = _spraysValue

    fun getSprays() = viewModelScope.launch {
        when (val result = spraysRepository.getSprays()) {
            is NetworkResult.Error -> {
                result.errorMsg.printToLog()
            }
            is NetworkResult.Exception -> {
                result.e.stackTraceToString().printToLog()
            }

            is NetworkResult.Success -> {
                result.data.printToLog()
                _spraysValue.value = result.data
            }
        }
    }
}