package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.maps.MapsResponse.Companion.toMapEntity
import com.slayer.data.local.dao.MapsDao
import com.slayer.data.local.entities.MapEntity.Companion.toMapModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.maps.MapModel
import com.slayer.domain.repositories.MapsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MapsRepoImpl  @Inject constructor(
    private val api : ApiService,
    private val mapsDao: MapsDao
) : MapsRepository, ApiHandler {
    override suspend fun getMapsFromNetwork(): NetworkResult<Any> {
        return handleApi(
            execute = { api.getMaps() },
            mapper = { data -> mapsDao.insertMap(data.toMapEntity()) }
        )
    }

    override suspend fun getMapsFromLocal(): Flow<List<MapModel>> {
        return mapsDao.getMaps().map { it.toMapModel() }
    }
}