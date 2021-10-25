package com.ninaestoye.findfriends.model

import android.os.Parcelable
import androidx.room.Embedded
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    val street : String,
    val zipcode : String,
    @Embedded
    val geo : Geo
) : Parcelable