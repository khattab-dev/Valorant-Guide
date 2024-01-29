package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.ranks.RanksResponse.Companion.toRankModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.ranks.RankModel
import com.slayer.domain.repositories.RanksRepository
import javax.inject.Inject

class RanksRepoImpl @Inject constructor(private val api: ApiService) : RanksRepository,
    ApiHandler {
    override suspend fun getRanks(): NetworkResult<Map<String,List<RankModel>>> {
        return handleApi(
            execute = { api.getRanks() },
            mapper = { data -> data.toRankModel() }
        )
    }
}