package com.slayer.data.api.dto.sprays


import com.slayer.data.local.entities.SprayEntity
import com.slayer.domain.models.sprays.SprayModel
import com.squareup.moshi.Json

data class SpraysResponse(
    @Json(name = "data")
    val `data`: List<SpraysData?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun SpraysResponse.toSpraysEntity(): List<SprayEntity> {
            return this.data?.map {
                SprayEntity(
                    uuid = it?.uuid ?: "",
                    image = it?.fullIcon ?: ""
                )
            }?.filter { it.image.isNotEmpty() } ?: emptyList()
        }
    }
}