package com.slayer.data.api.dto.maps


import com.squareup.moshi.Json

data class MapsDataResponse(
    @Json(name = "assetPath")
    val assetPath: String?,
    @Json(name = "callouts")
    val callouts: List<Callout?>?,
    @Json(name = "coordinates")
    val coordinates: String?,
    @Json(name = "displayIcon")
    val displayIcon: String?,
    @Json(name = "displayName")
    val displayName: String?,
    @Json(name = "listViewIcon")
    val listViewIcon: String?,
    @Json(name = "listViewIconTall")
    val listViewIconTall: String?,
    @Json(name = "mapUrl")
    val mapUrl: String?,
    @Json(name = "narrativeDescription")
    val narrativeDescription: String?,
    @Json(name = "premierBackgroundImage")
    val premierBackgroundImage: String?,
    @Json(name = "splash")
    val splash: String?,
    @Json(name = "stylizedBackgroundImage")
    val stylizedBackgroundImage: String?,
    @Json(name = "tacticalDescription")
    val tacticalDescription: String?,
    @Json(name = "uuid")
    val uuid: String?,
    @Json(name = "xMultiplier")
    val xMultiplier: Double?,
    @Json(name = "xScalarToAdd")
    val xScalarToAdd: Double?,
    @Json(name = "yMultiplier")
    val yMultiplier: Double?,
    @Json(name = "yScalarToAdd")
    val yScalarToAdd: Double?
)