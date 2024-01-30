package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.maps.MapModel
import com.slayer.domain.models.weapons.WeaponModel
import kotlinx.coroutines.flow.Flow

interface MapsRepository {
    suspend fun getMapsFromNetwork(): NetworkResult<Any>
    suspend fun getMapsFromLocal(): Flow<List<MapModel>>
}