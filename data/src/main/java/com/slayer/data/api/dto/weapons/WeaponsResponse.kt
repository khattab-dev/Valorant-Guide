package com.slayer.data.api.dto.weapons


import com.slayer.domain.models.weapons.WeaponModel
import com.squareup.moshi.Json

data class WeaponsResponse(
    @Json(name = "data")
    val `data`: List<WeaponsDataResponse?>?,
    @Json(name = "status")
    val status: Int?
) {
    companion object {
        fun WeaponsResponse.toWeaponModel(): List<WeaponModel> {
            return this.data?.map {
                WeaponModel(
                    uuid = it?.uuid ?: "",
                    name = it?.displayName ?: "",
                    image = it?.displayIcon ?: ""
                )
            } ?: emptyList()
        }
    }
}