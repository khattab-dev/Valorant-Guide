package com.slayer.domain.repositories

import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.sprays.SprayModel

interface SpraysRepository {
    suspend fun getSprays(): NetworkResult<List<SprayModel>>
}