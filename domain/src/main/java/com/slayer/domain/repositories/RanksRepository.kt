package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.ranks.RankModel
import kotlinx.coroutines.flow.Flow

interface RanksRepository {
    suspend fun getRanksFromNetwork(): NetworkResult<Any>
    suspend fun getRanksFromLocal(): Flow<List<RankModel>>
}