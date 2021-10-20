package com.ninaestoye.findfriends.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country (
    val id: Int,
    val name: String
) : Parcelable