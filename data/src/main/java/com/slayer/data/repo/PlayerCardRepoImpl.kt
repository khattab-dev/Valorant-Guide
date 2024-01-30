package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.cards.PlayerCardsResponse.Companion.toCardEntity
import com.slayer.data.local.dao.PlayerCardsDao
import com.slayer.data.local.entities.PlayerCardEntity.Companion.toCardModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.cards.CardModel
import com.slayer.domain.repositories.PlayerCardsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlayerCardRepoImpl @Inject constructor(
    private val api: ApiService,
    private val dao : PlayerCardsDao
) : PlayerCardsRepository,
    ApiHandler {
    override suspend fun getPlayerCardsFromNetwork(): NetworkResult<Any> {
        return handleApi(
            execute = { api.getPlayerCards() },
            mapper = { data -> dao.insertCard(data.toCardEntity()) }
        )
    }

    override suspend fun getPlayerCardsFromLocal(): Flow<List<CardModel>> {
        return dao.getCards().map { it.toCardModel() }
    }
}