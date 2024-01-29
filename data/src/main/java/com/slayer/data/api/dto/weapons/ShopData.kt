package com.slayer.data.api.dto.weapons


import com.squareup.moshi.Json

data class ShopData(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "canBeTrashed")
    val canBeTrashed: Boolean?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "categoryText")
    val categoryText: String?,
    @Json(name = "cost")
    val cost: Int?,
    @Json(name = "gridPosition")
    val gridPosition: GridPosition?,
    @Json(name = "image")
    val image: Any?,
    @Json(name = "newImage")
    val newImage: String?,
    @Json(name = "newImage2")
    val newImage2: Any?,
    @Json(name = "shopOrderPriority")
    val shopOrderPriority: Int?
)