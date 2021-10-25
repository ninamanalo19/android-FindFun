package com.ninaestoye.findfriends.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Geo(
    val lat: Double,
    val lng: Double
) : Parcelable