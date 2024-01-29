package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.agents.AgentsResponse.Companion.toAgentsModel
import com.slayer.domain.repositories.AgentsRepository
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.agents.AgentModel
import javax.inject.Inject

class AgentsRepoImpl @Inject constructor(private val api: ApiService) : AgentsRepository,
    ApiHandler {
    override suspend fun getAgents(): NetworkResult<List<AgentModel>> {
        return handleApi(
            execute = { api.getAgents() },
            mapper = { data -> data.toAgentsModel() }
        )
    }
}