package com.ninaestoye.findfriends.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.ninaestoye.findfriends.data.DBConstants
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "friend_table")
data class Friend (
    @PrimaryKey
    val id: Int,
    val name: String,
    val username: String,
    val phone: String,
    @Embedded
    val address: Address
) : Parcelable