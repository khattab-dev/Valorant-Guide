package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.agents.AgentsResponse.Companion.toAgentsEntity
import com.slayer.data.local.dao.AgentsDao
import com.slayer.data.local.entities.AgentEntity.Companion.toAgentsModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.agents.AgentModel
import com.slayer.domain.repositories.AgentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AgentsRepoImpl @Inject constructor(
    private val api: ApiService,
    private val agentsDao: AgentsDao
) : AgentsRepository, ApiHandler {
    override suspend fun getAgentsFromApi(): NetworkResult<Any> {
        return handleApi(
            execute = { api.getAgents() },
            mapper = { data ->
                agentsDao.insertAgent(data.toAgentsEntity())
            }
        )
    }

    override suspend fun getAgentsFromLocal(): Flow<List<AgentModel>> {
        return agentsDao.getAgents().map { it.toAgentsModel() }
    }
}