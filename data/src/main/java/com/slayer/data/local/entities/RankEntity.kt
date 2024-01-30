package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.ranks.RankModel

@Entity("rank_table")
data class RankEntity(
    @PrimaryKey
    val uuid: Int,
    val tier : String,
    val divisionName: String,
    val divisionIcon: String
) {
    companion object {
        fun List<RankEntity>.toRankModel(): List<RankModel> {
            return this.map {
                RankModel(
                    id = it.uuid,
                    divisionName = it.divisionName,
                    tierName = it.tier,
                    divisionIcon = it.divisionIcon,
                )
            }
        }

    }
}