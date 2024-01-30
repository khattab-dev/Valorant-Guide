package com.slayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.slayer.data.local.entities.SprayEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SpraysDao {
    @Query("SELECT * FROM spray_table")
    fun getSprays() : Flow<List<SprayEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpray(sprayEntity: SprayEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpray(sprayEntities: List<SprayEntity>)


    @Delete
    fun deleteSpray(sprayEntity: SprayEntity)

    @Update
    fun updateSpray(sprayEntity: SprayEntity)
}