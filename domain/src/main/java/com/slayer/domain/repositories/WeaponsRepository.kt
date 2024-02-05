package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.weapons.WeaponModel
import kotlinx.coroutines.flow.Flow

interface WeaponsRepository {
    suspend fun getWeaponsFromNetwork(): NetworkResult<Any>
    suspend fun getWeaponsFromLocal(): Flow<List<WeaponModel>>
    suspend fun getWeaponFromLocal(id: String): Flow<WeaponModel>
}