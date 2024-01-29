package com.slayer.data.api.dto.agents


import com.squareup.moshi.Json

data class Role(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "uuid")
    val uuid: String?
)