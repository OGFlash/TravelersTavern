package com.wildlab.travelerstavern.db.table

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * CharacterStats Room Persistence table.
 *
 * This table relates to Character table with foreign key character_id
 *
 * @author asadana
 * @since 12/9/2018
 */
@Entity(tableName = "character_stats",
        foreignKeys = [ForeignKey(
                entity = Character::class,
                parentColumns = arrayOf("character_id"),
                childColumns = arrayOf("character_id")
        )])
data class CharacterStats(
        @PrimaryKey @ColumnInfo(name = "character_id") var characterId: Int,
        @ColumnInfo(name = "character_strength") var characterStrength: Int,
        @ColumnInfo(name = "character_dexterity") var characterDexterity: Int,
        @ColumnInfo(name = "character_constitution") var characterConstitution: Int,
        @ColumnInfo(name = "character_intelligence") var characterIntelligence: Int,
        @ColumnInfo(name = "character_wisdom") var characterWisdom: Int,
        @ColumnInfo(name = "character_charisma") var characterCharisma: Int
)