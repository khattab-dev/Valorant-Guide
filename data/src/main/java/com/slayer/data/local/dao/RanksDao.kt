package com.slayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.slayer.data.local.entities.RankEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RanksDao {
    @Query("SELECT * FROM rank_table")
    fun getRanks() : Flow<List<RankEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRank(rankEntity: RankEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRank(rankEntities: List<RankEntity>)


    @Delete
    fun deleteRank(rankEntity: RankEntity)

    @Update
    fun updateRank(rankEntity: RankEntity)
}