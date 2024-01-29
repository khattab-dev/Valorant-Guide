package com.slayer.data.api.dto.buddies


import com.squareup.moshi.Json

data class Level(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "charmLevel")
    val charmLevel: Int?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "hideIfNotOwned")
    val hideIfNotOwned: Boolean?,
    @Json(name = "uuid")
    val uuid: String?
)