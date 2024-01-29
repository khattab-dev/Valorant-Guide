package com.slayer.data.api.dto.ranks


import com.slayer.domain.models.ranks.RankModel
import com.squareup.moshi.Json

data class RanksResponse(
    @Json(name = "data")
    val `data`: List<RanksData?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun RanksResponse.toRankModel(): Map<String,List<RankModel>> {
            return this.data?.last()?.tiers?.groupBy {
                it?.divisionName ?: ""
            }?.mapValues { (_, tiers) ->
                tiers.map { tier ->
                    RankModel(
                        id = tier?.tier ?: 0,
                        divisionName = tier?.divisionName ?: "",
                        divisionIcon = tier?.largeIcon ?: ""
                    )
                }
            } ?: emptyMap()
        }
    }
}
