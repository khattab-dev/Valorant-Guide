package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.agents.AgentModel
import com.slayer.domain.models.buddies.BuddyModel
import kotlinx.coroutines.flow.Flow

interface BuddiesRepository {
    suspend fun getBuddies(): NetworkResult<Any>

    suspend fun getBuddiesFromLocal(): Flow<List<BuddyModel>>

}