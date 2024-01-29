package com.slayer.data.api.dto.maps


import com.slayer.domain.models.maps.MapModel
import com.squareup.moshi.Json

data class MapsResponse(
    @Json(name = "data")
    val `data`: List<MapsDataResponse?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun MapsResponse.toMapModel(): List<MapModel> {
            return this.data?.map {
                MapModel(
                    uuid = it?.uuid ?: "",
                    name = it?.displayName ?: "",
                    image = it?.displayIcon ?: ""
                )
            } ?: emptyList()
        }
    }
}