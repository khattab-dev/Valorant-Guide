package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.agents.AgentModel

@Entity(tableName = "agents_table")
data class AgentEntity(
    @PrimaryKey
    val uuid: String,
    val name: String,
    val agentImage: String
) {
    companion object {
        fun List<AgentEntity>.toAgentsModel(): List<AgentModel> {
            return this.map {
                AgentModel(
                    uuid = it.uuid,
                    name = it.name,
                    image = it.agentImage
                )
            }
        }
    }
}
