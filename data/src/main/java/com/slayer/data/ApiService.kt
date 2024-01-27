package com.slayer.data

import com.slayer.data.dto.AgentsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("agents")
    suspend fun getAgents() : Response<AgentsResponse>
}