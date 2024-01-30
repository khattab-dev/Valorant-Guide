package com.slayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.slayer.data.local.entities.AgentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentsDao {
    @Query("SELECT * FROM agents_table")
    fun getAgents() : Flow<List<AgentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAgent(agentEntity: AgentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAgent(agentEntities: List<AgentEntity>)


    @Delete
    fun deleteAgent(agentEntity: AgentEntity)

    @Update
    fun updateAgent(agentEntity: AgentEntity)
}