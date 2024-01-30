package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.cards.CardModel
import com.slayer.domain.models.weapons.WeaponModel
import kotlinx.coroutines.flow.Flow

interface PlayerCardsRepository {
    suspend fun getPlayerCardsFromNetwork(): NetworkResult<Any>
    suspend fun getPlayerCardsFromLocal(): Flow<List<CardModel>>
}