package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.maps.MapModel

@Entity("map_table")
data class MapEntity(
    @PrimaryKey
    val uuid: String,
    val name: String,
    val image: String,
) {
    companion object {
        fun List<MapEntity>.toMapModel(): List<MapModel> {
            return this.map {
                MapModel(
                    uuid = it.uuid,
                    name = it.name,
                    image = it.image
                )
            }
        }
    }
}