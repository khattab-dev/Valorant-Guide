package com.slayer.data.api.dto.agents


import com.slayer.common.hexColorToLong
import com.slayer.data.local.entities.AgentEntity
import com.slayer.domain.models.agents.AgentAbilityModel
import com.squareup.moshi.Json

data class AgentsResponse(
    @Json(name = "data")
    val `data`: List<AgentsData?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun AgentsResponse.toAgentsEntity(): List<AgentEntity> {
            return this.data?.map {agent ->
                AgentEntity(
                    uuid = agent?.uuid ?: "",
                    name = agent?.displayName ?: "",
                    agentImage = agent?.bustPortrait ?: "",
                    description = agent?.description ?: "",
                    developerName = agent?.developerName ?: "",
                    type = agent?.role?.displayName ?: "",
                    typeDisplayIcon = agent?.role?.displayIcon ?: "",
                    agentBackground = agent?.background ?: "",
                    agentBackgroundColors = agent?.backgroundGradientColors?.map {
                        hexColorToLong(it ?: "")
                    } ?: emptyList(),
                    agentAbility = agent?.abilities?.map {
                        AgentAbilityModel(
                            name = it?.displayName ?: "",
                            description = it?.description ?: "",
                            icon = it?.displayIcon ?: "",
                        )
                    } ?: emptyList()
                )
            } ?: emptyList()
        }
    }
}
