package com.slayer.data.dto


import com.slayer.domain.models.AgentModel
import com.squareup.moshi.Json

data class AgentsResponse(
    @Json(name = "data")
    val `data`: List<AgentsData?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun AgentsResponse.toAgentsModel(): List<AgentModel> {
            return this.data?.map {
                AgentModel(uuid = it?.uuid ?: "",
                    name = it?.displayName ?: "",
                    image = it?.bustPortrait ?: ""
                )
            } ?: emptyList()
        }
    }
}