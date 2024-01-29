package com.slayer.data.api

import com.slayer.data.api.dto.agents.AgentsResponse
import com.slayer.data.api.dto.buddies.BuddiesResponse
import com.slayer.data.api.dto.cards.PlayerCardsResponse
import com.slayer.data.api.dto.maps.MapsResponse
import com.slayer.data.api.dto.ranks.RanksResponse
import com.slayer.data.api.dto.sprays.SpraysResponse
import com.slayer.data.api.dto.weapons.WeaponsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("agents")
    suspend fun getAgents(
        @Query("isPlayableCharacter") isPlayableChar: Boolean = true
    ): Response<AgentsResponse>

    @GET("buddies")
    suspend fun getBuddies(): Response<BuddiesResponse>

    @GET("weapons")
    suspend fun getWeapons(): Response<WeaponsResponse>

    @GET("maps")
    suspend fun getMaps(): Response<MapsResponse>

    @GET("competitivetiers")
    suspend fun getRanks(): Response<RanksResponse>

    @GET("sprays")
    suspend fun getSprays(): Response<SpraysResponse>

    @GET("playercards")
    suspend fun getPlayerCards(): Response<PlayerCardsResponse>
}