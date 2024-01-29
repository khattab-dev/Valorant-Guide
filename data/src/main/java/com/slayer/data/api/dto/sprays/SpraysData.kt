package com.slayer.data.api.dto.sprays


import com.squareup.moshi.Json

data class SpraysData(
    @Json(name = "animationGif")
    val animationGif: String?,
    @Json(name = "animationPng")
    val animationPng: String?,
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "fullIcon")
    val fullIcon: String?,
    @Json(name = "fullTransparentIcon")
    val fullTransparentIcon: String?,
    @Json(name = "hideIfNotOwned")
    val hideIfNotOwned: Boolean?,
    @Json(name = "isNullSpray")
    val isNullSpray: Boolean?,
    @Json(name = "levels")
    val levels: List<Level?>?,
    @Json(name = "themeUuid")
    val themeUuid: String?,
    @Json(name = "uuid")
    val uuid: String?
)