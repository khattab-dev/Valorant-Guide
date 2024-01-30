package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.sprays.SprayModel
import com.slayer.domain.models.weapons.WeaponModel
import kotlinx.coroutines.flow.Flow

interface SpraysRepository {
    suspend fun getSpraysFromNetwork(): NetworkResult<Any>
    suspend fun getSpraysFromLocal(): Flow<List<SprayModel>>
}