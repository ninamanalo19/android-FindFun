package com.ninaestoye.findfriends.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val lat: Double,
    val long: Double
) : Parcelable