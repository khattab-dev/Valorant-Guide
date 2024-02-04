package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.agents.AgentAbilityModel
import com.slayer.domain.models.agents.AgentModel

@Entity(tableName = "agents_table")
data class AgentEntity(
    @PrimaryKey
    val uuid: String,
    val name: String,
    val agentImage: String,
    val description: String,
    val developerName: String,
    val type: String,
    val typeDisplayIcon: String,
    val agentBackground: String,
    val agentBackgroundColors : List<Long>,
    val agentAbility : List<AgentAbilityModel>
) {
    companion object {
        fun List<AgentEntity>.toAgentsModel(): List<AgentModel> {
            return this.map {
                AgentModel(
                    uuid = it.uuid,
                    name = it.name,
                    image = it.agentImage,
                    description = it.description,
                    developerName = it.developerName,
                    type = it.type,
                    typeDisplayIcon = it.typeDisplayIcon,
                    background = it.agentBackground,
                    backgroundGradient = it.agentBackgroundColors,
                    abilities = it.agentAbility
                )
            }
        }

        fun AgentEntity.toAgentModel(): AgentModel {
            return AgentModel(
                uuid = this.uuid,
                name = this.name,
                image = this.agentImage,
                description = this.description,
                developerName = this.developerName,
                type = this.type,
                typeDisplayIcon = this.typeDisplayIcon,
                background = this.agentBackground,
                backgroundGradient = this.agentBackgroundColors,
                abilities = this.agentAbility
            )
        }
    }
}
