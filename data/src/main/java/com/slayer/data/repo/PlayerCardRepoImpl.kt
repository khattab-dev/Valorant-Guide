package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.cards.PlayerCardsResponse.Companion.toPlayerCardModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.cards.CardModel
import com.slayer.domain.repositories.PlayerCardsRepository
import javax.inject.Inject

class PlayerCardRepoImpl @Inject constructor(private val api: ApiService) : PlayerCardsRepository,
    ApiHandler {
    override suspend fun getPlayerCards(): NetworkResult<List<CardModel>> {
        return handleApi(
            execute = { api.getPlayerCards() },
            mapper = { data -> data.toPlayerCardModel() }
        )
    }
}