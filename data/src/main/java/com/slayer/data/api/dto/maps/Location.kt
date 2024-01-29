package com.slayer.data.api.dto.maps


import com.squareup.moshi.Json

data class Location(
    @Json(name = "x")
    val x: Double?,
    @Json(name = "y")
    val y: Double?
)