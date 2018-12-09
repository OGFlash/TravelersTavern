package com.wildlab.travelerstavern.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.wildlab.travelerstavern.db.table.Character

/**
 * CharacterDao is a DAO interface for the Character table.
 *
 * @author asadana
 * @since 12/9/2018
 */
@Dao
interface CharacterDao{
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun addCharacter(character: Character): Boolean

    @Update
    fun updateCharacter(character: Character): Boolean

    @Delete
    fun deleteCharacter(character: Character): Boolean

    @Query("SELECT * FROM characters WHERE user_id = :userID")
    fun getUserCharacters(userID: Int): LiveData<List<Character>>
}