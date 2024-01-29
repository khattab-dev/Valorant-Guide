package com.slayer.data.api.dto.buddies


import com.squareup.moshi.Json

data class BuddiesDataResponse(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "isHiddenIfNotOwned")
    val isHiddenIfNotOwned: Boolean?,
    @Json(name = "levels")
    val levels: List<Level?>?,
    @Json(name = "themeUuid")
    val themeUuid: String?,
    @Json(name = "uuid")
    val uuid: String?
)