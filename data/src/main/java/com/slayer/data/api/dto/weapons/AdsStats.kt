package com.slayer.data.api.dto.weapons


import com.squareup.moshi.Json

data class AdsStats(
    @Json(name = "burstCount")
    val burstCount: Int?,
    @Json(name = "fireRate")
    val fireRate: Double?,
    @Json(name = "firstBulletAccuracy")
    val firstBulletAccuracy: Double?,
    @Json(name = "runSpeedMultiplier")
    val runSpeedMultiplier: Double?,
    @Json(name = "zoomMultiplier")
    val zoomMultiplier: Double?
)