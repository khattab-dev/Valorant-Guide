package com.slayer.data.api.dto.weapons


import com.squareup.moshi.Json

data class WeaponsDataResponse(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "defaultSkinUuid")
    val defaultSkinUuid: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "killStreamIcon")
    val killStreamIcon: String?,
    @Json(name = "shopData")
    val shopData: ShopData?,
    @Json(name = "skins")
    val skins: List<Skin?>?,
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "weaponStats")
    val weaponStats: WeaponStats?
)