package com.slayer.data.api.dto.maps


import com.slayer.data.local.entities.MapEntity
import com.squareup.moshi.Json

data class MapsResponse(
    @Json(name = "data")
    val `data`: List<MapsDataResponse?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun MapsResponse.toMapEntity(): List<MapEntity> {
            return this.data?.map {
                MapEntity(
                    uuid = it?.uuid ?: "",
                    name = it?.displayName ?: "",
                    image = it?.displayIcon ?: ""
                )
            } ?: emptyList()
        }
    }
}