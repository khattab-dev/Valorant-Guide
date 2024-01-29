package com.slayer.valorantguide.screens.ranks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.common.printToLog
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.ranks.RankModel
import com.slayer.domain.repositories.RanksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RanksViewModel @Inject constructor(
    private val ranksRepository: RanksRepository
) : ViewModel() {
    private val _ranksValue = mutableStateOf<Map<String,List<RankModel>>?>(null)
    val ranksValue: State<Map<String,List<RankModel>>?> = _ranksValue

    fun getPlayerCards() = viewModelScope.launch {
        when (val result = ranksRepository.getRanks()) {
            is NetworkResult.Error -> {
                result.errorMsg.printToLog()
            }
            is NetworkResult.Exception -> {
                result.e.stackTraceToString().printToLog()
            }

            is NetworkResult.Success -> {
                result.data.printToLog()
                _ranksValue.value = result.data
            }
        }
    }
}