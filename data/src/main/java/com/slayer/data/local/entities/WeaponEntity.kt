package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.weapons.WeaponModel

@Entity("weapon_table")
data class WeaponEntity(
    @PrimaryKey
    val uuid: String,
    val name: String,
    val image: String
) {
    companion object {
        fun List<WeaponEntity>.toWeaponModel(): List<WeaponModel> {
            return this.map {
                WeaponModel(
                    uuid = it.uuid,
                    image = it.image,
                    name = it.name
                )
            }
        }
    }
}