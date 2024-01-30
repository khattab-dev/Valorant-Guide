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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RanksViewModel @Inject constructor(
    private val ranksRepository: RanksRepository
) : ViewModel() {
    private val _ranksValue = mutableStateOf<Map<String,List<RankModel>>?>(null)
    val ranksValue: State<Map<String,List<RankModel>>?> = _ranksValue

    private fun getRanksFromNetwork() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = ranksRepository.getRanksFromNetwork()) {
            is NetworkResult.Error -> {
                result.errorMsg.printToLog()
            }
            is NetworkResult.Exception -> {
                result.e.stackTraceToString().printToLog()
            }

            is NetworkResult.Success -> {}
        }
    }

    fun getPlayerCardsFromLocal() = viewModelScope.launch(Dispatchers.IO) {
        ranksRepository.getRanksFromLocal().collect {
            if (it.isNotEmpty()) { _ranksValue.value = it.groupBy { it.divisionName } }
            else { getRanksFromNetwork() }
        }
    }
}