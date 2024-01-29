package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.weapons.WeaponModel

interface WeaponsRepository {
    suspend fun getWeapons(): NetworkResult<List<WeaponModel>>
}