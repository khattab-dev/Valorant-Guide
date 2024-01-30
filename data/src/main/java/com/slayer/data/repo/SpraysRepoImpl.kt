package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.sprays.SpraysResponse.Companion.toSpraysEntity
import com.slayer.data.local.dao.SpraysDao
import com.slayer.data.local.entities.SprayEntity.Companion.toSprayModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.sprays.SprayModel
import com.slayer.domain.repositories.SpraysRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SpraysRepoImpl @Inject constructor(
    private val api : ApiService,
    private val dao : SpraysDao
) : SpraysRepository,ApiHandler {
    override suspend fun getSpraysFromNetwork(): NetworkResult<Any> {
        return handleApi(
            execute = { api.getSprays() },
            mapper = { data -> dao.insertSpray(data.toSpraysEntity()) }
        )
    }

    override suspend fun getSpraysFromLocal(): Flow<List<SprayModel>> {
        return dao.getSprays().map { it.toSprayModel() }
    }
}