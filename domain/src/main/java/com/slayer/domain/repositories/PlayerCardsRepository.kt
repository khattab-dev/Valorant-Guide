package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.cards.CardModel

interface PlayerCardsRepository {
    suspend fun getPlayerCards(): NetworkResult<List<CardModel>>
}