package com.slayer.data.api.dto.weapons


import com.squareup.moshi.Json

data class GridPosition(
    @Json(name = "column")
    val column: Int?,
    @Json(name = "row")
    val row: Int?
)