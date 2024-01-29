package com.slayer.domain.repositories

import com.slayer.domain.models.agents.AgentModel
import com.slayer.domain.models.NetworkResult

interface AgentsRepository {
    suspend fun getAgents(): NetworkResult<List<AgentModel>>
}