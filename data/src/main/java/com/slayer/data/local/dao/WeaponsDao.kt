package com.slayer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.slayer.data.local.entities.WeaponEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeaponsDao {
    @Query("SELECT * FROM weapon_table")
    fun getWeapons() : Flow<List<WeaponEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeapon(weaponEntity: WeaponEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeapon(weaponEntities: List<WeaponEntity>)


    @Delete
    fun deleteWeapon(weaponEntity: WeaponEntity)

    @Update
    fun updateWeapon(weaponEntity: WeaponEntity)
}