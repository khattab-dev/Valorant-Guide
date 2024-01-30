package com.slayer.data.api.dto.weapons


import com.slayer.data.local.entities.WeaponEntity
import com.slayer.domain.models.weapons.WeaponModel
import com.squareup.moshi.Json

data class WeaponsResponse(
    @Json(name = "data")
    val `data`: List<WeaponsDataResponse?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun WeaponsResponse.toWeaponEntity(): List<WeaponEntity> {
            return this.data?.map {
                WeaponEntity(
                    uuid = it?.uuid ?: "",
                    name = it?.displayName ?: "",
                    image = it?.displayIcon ?: ""
                )
            } ?: emptyList()
        }
    }
}