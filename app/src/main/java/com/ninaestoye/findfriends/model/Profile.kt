package com.ninaestoye.findfriends.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "profile_table")
data class Profile (
    @PrimaryKey
    val id: Int,
    val firstName: String,
    val lastName: String,
    val photo: String,
    @Embedded
    val geo: Geo
) : Parcelable