package com.wildlab.travelerstavern.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.support.annotation.VisibleForTesting
import com.wildlab.travelerstavern.db.dao.CharacterDao
import com.wildlab.travelerstavern.db.dao.CharacterStatsDao
import com.wildlab.travelerstavern.db.dao.UserDao
import com.wildlab.travelerstavern.db.table.Character
import com.wildlab.travelerstavern.db.table.CharacterStats
import com.wildlab.travelerstavern.db.table.User
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.content.Context
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock


/**
 * TravelersTavernDB extends {@link RoomDatabase}
 */
@Database(
        entities = [
            User::class,
            Character::class,
            CharacterStats::class],
        version = 1
)
abstract class TravelersTavernDB : RoomDatabase() {

    private lateinit var instance: TravelersTavernDB
    private val lock = ReentrantLock()

    abstract fun userDao(): UserDao
    abstract fun characterDao(): CharacterDao
    abstract fun characterStatsDao(): CharacterStatsDao

    @VisibleForTesting
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
           // Migration from v1 to v2 will go here
        }
    }

    fun getInstance(context: Context) : TravelersTavernDB {
        lock.withLock {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        TravelersTavernDB::class.java, "TravelersTavern.db")
                        .addMigrations(MIGRATION_1_2)
                        .build()
            }
            return instance
        }
    }
}