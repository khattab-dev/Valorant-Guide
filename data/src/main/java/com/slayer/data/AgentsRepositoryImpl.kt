package com.slayer.data

import com.slayer.common.printToLog
import com.slayer.data.dto.AgentsResponse.Companion.toAgentsModel
import com.slayer.domain.AgentsRepository
import com.slayer.domain.models.AgentModel
import javax.inject.Inject

class AgentsRepositoryImpl @Inject constructor(private val api: ApiService) : AgentsRepository {
    override suspend fun getAgents(): List<AgentModel> {
        return try {
            val response = api.getAgents()
            if (response.isSuccessful) {
                response.body()?.toAgentsModel() ?: emptyList()
            } else {
                response.body().printToLog()
                emptyList()
            }
        } catch (e : Exception) {
            e.stackTraceToString().printToLog()
            emptyList()
        }
    }
}