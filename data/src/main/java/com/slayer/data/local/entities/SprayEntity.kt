package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.sprays.SprayModel

@Entity("spray_table")

data class SprayEntity (
    @PrimaryKey
    val uuid : String,
    val image : String
) {
    companion object {
        fun List<SprayEntity>.toSprayModel(): List<SprayModel> {
            return this.map {
                SprayModel(
                    uuid = it.uuid,
                    image = it.image
                )
            }
        }
    }
}