package com.slayer.data.api.dto.buddies


import com.slayer.domain.models.buddies.BuddyModel
import com.squareup.moshi.Json

data class BuddiesResponse(
    @Json(name = "data")
    val `data`: List<BuddiesDataResponse?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun BuddiesResponse.toBuddyModel(): List<BuddyModel> {
            return this.data?.map {
                BuddyModel(
                    uuid = it?.uuid ?: "",
                    name = it?.displayName ?: "",
                    image = it?.displayIcon ?: ""
                )
            } ?: emptyList()
        }
    }
}