package com.slayer.data.api.dto.cards


import com.squareup.moshi.Json

data class PlayerCardsData(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "isHiddenIfNotOwned")
    val isHiddenIfNotOwned: Boolean?,
    @Json(name = "largeArt")
    val largeArt: String?,
    @Json(name = "smallArt")
    val smallArt: String?,
    @Json(name = "themeUuid")
    val themeUuid: String?,
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "wideArt")
    val wideArt: String?
)