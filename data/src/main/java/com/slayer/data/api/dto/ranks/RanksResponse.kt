package com.slayer.data.api.dto.ranks


import com.slayer.data.local.entities.RankEntity
import com.squareup.moshi.Json

data class RanksResponse(
    @Json(name = "data")
    val `data`: List<RanksData?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun RanksResponse.toRankEntity(): List<RankEntity> {
            return this.data?.filterNotNull()?.last()?.tiers?.map { division ->
                RankEntity(
                    uuid = division?.tier  ?: 0,
                    tier = division?.tierName  ?: "",
                    divisionName = division?.divisionName  ?: "",
                    divisionIcon = division?.largeIcon ?: ""
                )
            }?: emptyList()
        }
    }
}
