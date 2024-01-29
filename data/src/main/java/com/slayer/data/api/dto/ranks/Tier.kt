package com.slayer.data.api.dto.ranks


import com.squareup.moshi.Json

data class Tier(
    @Json(name = "backgroundColor")
    val backgroundColor: String?,
    @Json(name = "color")
    val color: String?,
    @Json(name = "division")
    val division: String?,
    @Json(name = "divisionName")
    val divisionName: String?,
    @Json(name = "largeIcon")
    val largeIcon: String?,
    @Json(name = "rankTriangleDownIcon")
    val rankTriangleDownIcon: String?,
    @Json(name = "rankTriangleUpIcon")
    val rankTriangleUpIcon: String?,
    @Json(name = "smallIcon")
    val smallIcon: String?,
    @Json(name = "tier")
    val tier: Int?,
    @Json(name = "tierName")
    val tierName: String?
)