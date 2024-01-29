package com.slayer.data.api.dto.ranks


import com.squareup.moshi.Json

data class RanksResponse(
    @Json(name = "data")
    val `data`: List<RanksData?>?,
    @Json(name = "status")
    val status: Int?
)