package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.weapons.WeaponModel

@Entity("weapon_table")
data class WeaponEntity(
    @PrimaryKey
    val uuid: String,
    val name: String,
    val image: String,
    val weaponStats : Map<String,String>,
    val adsStats : Map<String,String>,
    val damageRanges: List<Map<String, String>>
) {


    companion object {
        fun List<WeaponEntity>.toWeaponModel(): List<WeaponModel> {
            return this.map {
                WeaponModel(
                    uuid = it.uuid,
                    image = it.image,
                    name = it.name,
                    weaponStats = it.weaponStats.filterValues { it.isNotEmpty() },
                    adsStats = it.adsStats.filterValues { it.isNotEmpty() },
                    damageRanges = it.damageRanges,
                )
            }
        }

        fun WeaponEntity.toWeaponModel(): WeaponModel {
            return WeaponModel(
                uuid = this.uuid,
                image = this.image,
                name = this.name,
                weaponStats = this.weaponStats.filterValues { it.isNotEmpty() },
                adsStats = this.adsStats.filterValues { it.isNotEmpty() },
                damageRanges = this.damageRanges,
            )
        }
    }
}