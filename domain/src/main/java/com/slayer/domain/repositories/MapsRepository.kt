package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.maps.MapModel

interface MapsRepository {
    suspend fun getMaps(): NetworkResult<List<MapModel>>
}