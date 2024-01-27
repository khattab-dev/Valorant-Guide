package com.slayer.data

import com.slayer.data.dto.AgentsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("agents")
    suspend fun getAgents(
        @Query("isPlayableCharacter") isPlayableChar : Boolean = true
    ) : Response<AgentsResponse>
}