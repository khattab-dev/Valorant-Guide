package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.weapons.WeaponsResponse.Companion.toWeaponModel
import com.slayer.domain.repositories.WeaponsRepository
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.weapons.WeaponModel
import javax.inject.Inject

class WeaponsRepoImpl @Inject constructor(private val api : ApiService) : WeaponsRepository,ApiHandler {
    override suspend fun getWeapons(): NetworkResult<List<WeaponModel>> {
        return handleApi(
            execute = { api.getWeapons() },
            mapper = { data -> data.toWeaponModel() }
        )
    }
}