package com.slayer.data.api.dto.maps


import com.squareup.moshi.Json

data class Callout(
    @Json(name = "location")
    val location: Location?,
    @Json(name = "regionName")
    val regionName: String?,
    @Json(name = "superRegionName")
    val superRegionName: String?
)