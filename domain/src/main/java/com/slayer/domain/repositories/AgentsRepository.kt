package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.agents.AgentModel
import kotlinx.coroutines.flow.Flow

interface AgentsRepository {
    suspend fun getAgentsFromApi(): NetworkResult<Any>
    suspend fun getAgentsFromLocal(): Flow<List<AgentModel>>

    suspend fun getAgentFromLocal(id : String) : Flow<AgentModel>
}