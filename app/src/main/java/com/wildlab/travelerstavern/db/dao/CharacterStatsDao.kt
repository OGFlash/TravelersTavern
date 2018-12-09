package com.wildlab.travelerstavern.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.wildlab.travelerstavern.db.table.CharacterStats

/**
 * CharacterStatsDao
 */
@Dao
interface CharacterStatsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacterStats(characterStats: CharacterStats): Boolean

    @Update
    fun updateCharacterStats(characterStats: CharacterStats): Boolean

    @Delete
    fun deleteCharacterStats(characterStats: CharacterStats): Boolean

    @Query("SELECT * FROM character_stats WHERE character_id = :characterID")
    fun getCharacterStatsByCharacterID(characterID: Int): LiveData<CharacterStats>
}