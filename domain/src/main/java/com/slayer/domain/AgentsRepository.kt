package com.slayer.domain

import com.slayer.domain.models.AgentModel

interface AgentsRepository {
    suspend fun getAgents() : List<AgentModel>
}