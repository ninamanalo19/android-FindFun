package com.ninaestoye.findfriends.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ninaestoye.findfriends.data.DBConstants
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = DBConstants.PROFILE_TABLE)
data class Profile (
    @PrimaryKey
    val id: Int,
    val firstName: String,
    val lastName: String,
    val photo: String,
    @Embedded
    val location: Location
) : Parcelable