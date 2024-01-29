package com.slayer.data.api.dto.ranks


import com.squareup.moshi.Json

data class RanksData(
    @Json(name = "assetObjectName")
    val assetObjectName: String?,
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "tiers")
    val tiers: List<Tier?>?,
    @Json(name = "uuid")
    val uuid: String?
)