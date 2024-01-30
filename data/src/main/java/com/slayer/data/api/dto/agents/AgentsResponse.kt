package com.slayer.data.api.dto.agents


import com.slayer.data.local.entities.AgentEntity
import com.squareup.moshi.Json

data class AgentsResponse(
    @Json(name = "data")
    val `data`: List<AgentsData?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun AgentsResponse.toAgentsEntity(): List<AgentEntity> {
            return this.data?.map {
                AgentEntity(uuid = it?.uuid ?: "",
                    name = it?.displayName ?: "",
                    agentImage = it?.bustPortrait ?: ""
                )
            } ?: emptyList()
        }
    }
}