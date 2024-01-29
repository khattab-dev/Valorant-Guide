package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.buddies.BuddiesResponse.Companion.toBuddyModel
import com.slayer.domain.repositories.BuddiesRepository
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.buddies.BuddyModel
import javax.inject.Inject

class BuddiesRepoImpl @Inject constructor(private val api : ApiService) : BuddiesRepository,ApiHandler {
    override suspend fun getBuddies(): NetworkResult<List<BuddyModel>> {
        return handleApi(
            execute = { api.getBuddies() },
            mapper = { data -> data.toBuddyModel() }
        )
    }
}