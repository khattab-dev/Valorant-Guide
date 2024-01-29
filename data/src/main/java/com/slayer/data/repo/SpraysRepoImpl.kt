package com.slayer.data.repo

import com.slayer.data.api.ApiHandler
import com.slayer.data.api.ApiService
import com.slayer.data.api.dto.sprays.SpraysResponse.Companion.toSpraysModel
import com.slayer.domain.models.NetworkResult
import com.slayer.domain.models.sprays.SprayModel
import com.slayer.domain.repositories.SpraysRepository
import javax.inject.Inject

class SpraysRepoImpl @Inject constructor(private val api : ApiService) : SpraysRepository,ApiHandler {
    override suspend fun getSprays(): NetworkResult<List<SprayModel>> {
        return handleApi(
            execute = { api.getSprays() },
            mapper = { data -> data.toSpraysModel() }
        )
    }
}