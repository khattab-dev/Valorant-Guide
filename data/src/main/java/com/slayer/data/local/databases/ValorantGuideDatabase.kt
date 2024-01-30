package com.slayer.data.local.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slayer.data.local.dao.AgentsDao
import com.slayer.data.local.dao.GunsBuddyDao
import com.slayer.data.local.dao.MapsDao
import com.slayer.data.local.dao.PlayerCardsDao
import com.slayer.data.local.dao.RanksDao
import com.slayer.data.local.dao.SpraysDao
import com.slayer.data.local.dao.WeaponsDao
import com.slayer.data.local.entities.AgentEntity
import com.slayer.data.local.entities.GunsBuddyEntity
import com.slayer.data.local.entities.MapEntity
import com.slayer.data.local.entities.PlayerCardEntity
import com.slayer.data.local.entities.RankEntity
import com.slayer.data.local.entities.SprayEntity
import com.slayer.data.local.entities.WeaponEntity

@Database(
    entities = [
        AgentEntity::class,
        GunsBuddyEntity::class,
        MapEntity::class,
        PlayerCardEntity::class,
        RankEntity::class,
        SprayEntity::class,
        WeaponEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ValorantGuideDatabase() : RoomDatabase() {
    abstract fun agentDao(): AgentsDao
    abstract fun buddyDao(): GunsBuddyDao
    abstract fun mapsDao(): MapsDao
    abstract fun playerCardDao(): PlayerCardsDao
    abstract fun rankDao(): RanksDao
    abstract fun sprayDao(): SpraysDao
    abstract fun weaponDao(): WeaponsDao
}