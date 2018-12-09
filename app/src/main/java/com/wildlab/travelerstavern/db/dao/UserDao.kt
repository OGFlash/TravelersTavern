package com.wildlab.travelerstavern.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.wildlab.travelerstavern.db.table.User

/**
 * UserDao is a DAO interface for the User table.
 *
 * @author asadana
 * @since 12/9/2018
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun addUser(newUser: User): Boolean

    @Query("SELECT * FROM users WHERE user_id = :userID")
    fun getUserById(userID: Int): User

    @Update
    fun updateUser(user: User): Boolean

    @Delete
    fun deleteUser(user: User): Boolean
}