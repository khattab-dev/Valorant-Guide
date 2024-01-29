package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.buddies.BuddyModel

interface BuddiesRepository {
    suspend fun getBuddies(): NetworkResult<List<BuddyModel>>
}