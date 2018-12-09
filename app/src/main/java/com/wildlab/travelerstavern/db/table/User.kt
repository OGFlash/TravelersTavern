package com.wildlab.travelerstavern.db.table

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.graphics.Bitmap
import android.support.annotation.NonNull
import java.util.Date

/**
 * User Room Persistence table.
 *
 * @author asadana
 * @since 12/8/2018
 */
@Entity(tableName = "users")
data class User(
        @PrimaryKey var userID: Int,
        @ColumnInfo(name = "username") @NonNull var username: String,
        @ColumnInfo(name = "access_date") var accessDate: Date,
        @ColumnInfo(name = "profile_image") @Ignore var profileImage: Bitmap
)