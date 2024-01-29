package com.slayer.data.api.dto.weapons


import com.squareup.moshi.Json

data class AltShotgunStats(
    @Json(name = "burstRate")
    val burstRate: Double?,
    @Json(name = "shotgunPelletCount")
    val shotgunPelletCount: Int?
)