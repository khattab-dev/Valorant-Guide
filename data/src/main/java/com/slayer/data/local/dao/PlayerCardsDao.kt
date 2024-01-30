package com.slayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.slayer.data.local.entities.PlayerCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerCardsDao {
    @Query("SELECT * FROM player_card_table")
    fun getCards() : Flow<List<PlayerCardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(mapEntity: PlayerCardEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(mapEntities: List<PlayerCardEntity>)


    @Delete
    fun deleteCard(cardEntity: PlayerCardEntity)

    @Update
    fun updateCard(cardEntity: PlayerCardEntity)
}