package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.ranks.RankModel

interface RanksRepository {
    suspend fun getRanks(): NetworkResult<Map<String,List<RankModel>>>
}