package com.slayer.data.api.dto.weapons


import com.slayer.data.local.entities.WeaponEntity
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
                    image = it?.displayIcon ?: "",
                    weaponStats = mapOf(
                        "Name" to (it?.displayName ?: ""),
                        "Type" to (it?.category?.split("::")?.last() ?: ""),
                        "Wall penetration" to (it?.weaponStats?.wallPenetration?.split("::")?.last() ?: ""),
                        "Fire rate" to (it?.weaponStats?.fireRate?.toString() ?: ""),
                        "Magazine size" to (it?.weaponStats?.magazineSize?.toString() ?: ""),
                        "Reload time (S)" to (it?.weaponStats?.reloadTimeSeconds?.toString() ?: ""),
                    ),
                    adsStats = mapOf(
                        "Fire rate" to (it?.weaponStats?.adsStats?.fireRate?.toString() ?: ""),
                        "Zoom" to (it?.weaponStats?.adsStats?.zoomMultiplier?.toString() ?: ""),
                    ),
                    damageRanges = emptyList(),
                )
            } ?: emptyList()
        }
    }
}