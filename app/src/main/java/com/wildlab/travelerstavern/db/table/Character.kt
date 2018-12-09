package com.wildlab.travelerstavern.db.table

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Character Room Persistence table.
 *
 * @author asadana
 * @since 12/8/2018
 */
@Entity(tableName = "characters",
        foreignKeys = [ForeignKey(
                entity = User::class,
                parentColumns = arrayOf("user_id"),
                childColumns = arrayOf("user_id")
        )])
data class Character(
        @PrimaryKey @ColumnInfo(name = "character_id") var characterId: Int,
        @ColumnInfo(name = "user_id") var userId: Int,
        @ColumnInfo(name = "character_name") var characterName: String,
        @ColumnInfo(name = "character_age") var characterAge: Int
)