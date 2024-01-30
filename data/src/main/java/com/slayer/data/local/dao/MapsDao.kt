package com.slayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.slayer.data.local.entities.MapEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MapsDao {
    @Query("SELECT * FROM map_table")
    fun getMaps() : Flow<List<MapEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMap(mapEntity: MapEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMap(mapEntities: List<MapEntity>)


    @Delete
    fun deleteMap(mapEntity: MapEntity)

    @Update
    fun updateMap(mapEntity: MapEntity)
}