package com.slayer.valorantguide.screens.player_cards

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slayer.common.printToLog
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.cards.CardModel
import com.slayer.domain.repositories.PlayerCardsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerCardsViewModel @Inject constructor(
    private val playerCardsRepository: PlayerCardsRepository
) : ViewModel() {
    private val _playerCards = mutableStateOf<List<CardModel>?>(null)
    val playerCards: State<List<CardModel>?> = _playerCards

    private fun getPlayerCardsFromNetwork() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = playerCardsRepository.getPlayerCardsFromNetwork()) {
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
        playerCardsRepository.getPlayerCardsFromLocal().collect {
            if (it.isNotEmpty()) { _playerCards.value = it }
            else { getPlayerCardsFromNetwork() }
        }
    }
}