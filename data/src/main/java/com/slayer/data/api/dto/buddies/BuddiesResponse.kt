package com.slayer.data.api.dto.buddies


import com.slayer.data.api.dto.agents.AgentsResponse
import com.slayer.data.local.entities.AgentEntity
import com.slayer.data.local.entities.GunsBuddyEntity
import com.slayer.domain.models.buddies.BuddyModel
import com.squareup.moshi.Json

data class BuddiesResponse(
    @Json(name = "data")
    val `data`: List<BuddiesDataResponse?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun BuddiesResponse.toBuddyEntity(): List<GunsBuddyEntity> {
            return this.data?.map {
                GunsBuddyEntity(uuid = it?.uuid ?: "",
                    name = it?.displayName ?: "",
                    buddyImage = it?.displayIcon ?: ""
                )
            } ?: emptyList()
        }
    }
}