package com.slayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.slayer.data.local.entities.GunsBuddyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GunsBuddyDao {
    @Query("SELECT * FROM buddies_table")
    fun getGunsBuddies() : Flow<List<GunsBuddyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGunsBuddy(buddy: GunsBuddyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGunsBuddy(buddies: List<GunsBuddyEntity>)

    @Delete
    fun deleteGunsBuddy(buddy: GunsBuddyEntity)

    @Update
    fun updateGunsBuddy(buddy: GunsBuddyEntity)
}