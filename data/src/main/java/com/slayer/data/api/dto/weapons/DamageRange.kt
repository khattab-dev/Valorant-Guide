package com.slayer.data.api.dto.weapons


import com.squareup.moshi.Json

data class DamageRange(
    @Json(name = "bodyDamage")
    val bodyDamage: Int?,
    @Json(name = "headDamage")
    val headDamage: Double?,
    @Json(name = "legDamage")
    val legDamage: Double?,
    @Json(name = "rangeEndMeters")
    val rangeEndMeters: Int?,
    @Json(name = "rangeStartMeters")
    val rangeStartMeters: Int?
)