package com.slayer.data.api.dto.cards


import com.slayer.domain.models.cards.CardModel
import com.squareup.moshi.Json

data class PlayerCardsResponse(
    @Json(name = "data")
    val `data`: List<PlayerCardsData?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun PlayerCardsResponse.toPlayerCardModel(): List<CardModel> {
            return this.data?.map {
                CardModel(
                    uuid = it?.uuid ?: "",
                    image = it?.largeArt ?: ""
                )
            } ?: emptyList()
        }
    }
}