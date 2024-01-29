package com.slayer.data.api.dto.weapons


import com.squareup.moshi.Json

data class Level(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "levelItem")
    val levelItem: String?,
    @Json(name = "streamedVideo")
    val streamedVideo: String?,
    @Json(name = "uuid")
    val uuid: String?
)