package com.slayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.slayer.domain.models.buddies.BuddyModel

@Entity(tableName = "buddies_table")
data class GunsBuddyEntity(
    @PrimaryKey
    val uuid: String,
    val name: String,
    val buddyImage: String
) {
    companion object {
        fun List<GunsBuddyEntity>.toBuddyModel(): List<BuddyModel> {
            return this.map {
                BuddyModel(
                    uuid = it.uuid,
                    name = it.name,
                    image = it.buddyImage
                )
            }
        }
    }
}
