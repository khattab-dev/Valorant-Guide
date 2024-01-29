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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerCardsViewModel @Inject constructor(
    private val playerCardsRepository: PlayerCardsRepository
) : ViewModel() {
    private val _playerCards = mutableStateOf<List<CardModel>?>(null)
    val playerCards: State<List<CardModel>?> = _playerCards

    fun getPlayerCards() = viewModelScope.launch {
        when (val result = playerCardsRepository.getPlayerCards()) {
            is NetworkResult.Error -> {
                result.errorMsg.printToLog()
            }
            is NetworkResult.Exception -> {
                result.e.stackTraceToString().printToLog()
            }

            is NetworkResult.Success -> {
                result.data.printToLog()
                _playerCards.value = result.data
            }
        }
    }
}