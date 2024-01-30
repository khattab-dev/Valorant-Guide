package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.ranks.RanksResponse.Companion.toRankEntity
import com.slayer.data.local.dao.RanksDao
import com.slayer.data.local.entities.RankEntity.Companion.toRankModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.ranks.RankModel
import com.slayer.domain.repositories.RanksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RanksRepoImpl @Inject constructor(
    private val api: ApiService,
    private val dao: RanksDao
) : RanksRepository,
    ApiHandler {
    override suspend fun getRanksFromNetwork(): NetworkResult<Any> {
        return handleApi(
            execute = { api.getRanks() },
            mapper = { data -> dao.insertRank(data.toRankEntity()) }
        )
    }

    override suspend fun getRanksFromLocal(): Flow<List<RankModel>> {
        return dao.getRanks().map { it.toRankModel() }
    }
}