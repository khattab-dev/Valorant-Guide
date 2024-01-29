package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.maps.MapsResponse.Companion.toMapModel
import com.slayer.domain.repositories.MapsRepository
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.maps.MapModel
import javax.inject.Inject

class MapsRepoImpl  @Inject constructor(private val api : ApiService) : MapsRepository, ApiHandler {
    override suspend fun getMaps(): NetworkResult<List<MapModel>> {
        return handleApi(
            execute = { api.getMaps() },
            mapper = { data -> data.toMapModel() }
        )
    }
}