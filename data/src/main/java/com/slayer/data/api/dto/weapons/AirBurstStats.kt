package com.slayer.data.api.dto.weapons


import com.squareup.moshi.Json

data class AirBurstStats(
    @Json(name = "burstDistance")
    val burstDistance: Double?,
    @Json(name = "shotgunPelletCount")
    val shotgunPelletCount: Int?
)