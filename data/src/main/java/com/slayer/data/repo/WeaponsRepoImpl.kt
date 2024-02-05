package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.weapons.WeaponsResponse.Companion.toWeaponEntity
import com.slayer.data.local.dao.WeaponsDao
import com.slayer.data.local.entities.WeaponEntity.Companion.toWeaponModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.weapons.WeaponModel
import com.slayer.domain.repositories.WeaponsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeaponsRepoImpl @Inject constructor(
    private val api : ApiService,
    private val dao : WeaponsDao
) : WeaponsRepository,ApiHandler {
    override suspend fun getWeaponsFromNetwork(): NetworkResult<Any> {
        return handleApi(
            execute = { api.getWeapons() },
            mapper = { data -> dao.insertWeapon(data.toWeaponEntity()) }
        )
    }

    override suspend fun getWeaponsFromLocal(): Flow<List<WeaponModel>> {
        return dao.getWeapons().map { it.toWeaponModel() }
    }

    override suspend fun getWeaponFromLocal(id : String): Flow<WeaponModel> {
        return dao.getWeaponById(id).map { it.toWeaponModel() }
    }
}