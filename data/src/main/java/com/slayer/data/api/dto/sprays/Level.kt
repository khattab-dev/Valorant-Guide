package com.slayer.data.api.dto.sprays


import com.squareup.moshi.Json

data class Level(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "sprayLevel")
    val sprayLevel: Int?,
    @Json(name = "uuid")
    val uuid: String?
)