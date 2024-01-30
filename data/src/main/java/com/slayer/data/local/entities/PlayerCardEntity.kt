package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.cards.CardModel

@Entity("player_card_table")
data class PlayerCardEntity(
    @PrimaryKey
    val uuid : String,
    val image : String
) {
    companion object {
        fun List<PlayerCardEntity>.toCardModel(): List<CardModel> {
            return this.map {
                CardModel(
                    uuid = it.uuid,
                    image = it.image
                )
            }
        }
    }
}