package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.buddies.BuddiesResponse.Companion.toBuddyEntity
import com.slayer.data.local.dao.GunsBuddyDao
import com.slayer.data.local.entities.GunsBuddyEntity.Companion.toBuddyModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.buddies.BuddyModel
import com.slayer.domain.repositories.BuddiesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BuddiesRepoImpl @Inject constructor(
    private val api: ApiService,
    private val buddyDao: GunsBuddyDao
) : BuddiesRepository, ApiHandler {
    override suspend fun getBuddies(): NetworkResult<Any> {
        return handleApi(
            execute = { api.getBuddies() },
            mapper = { data ->
                buddyDao.insertGunsBuddy(data.toBuddyEntity())
            }
        )
    }

    override suspend fun getBuddiesFromLocal(): Flow<List<BuddyModel>> {
        return buddyDao.getGunsBuddies().map { it.toBuddyModel() }
    }
}