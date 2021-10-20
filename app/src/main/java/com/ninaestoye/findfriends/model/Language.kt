package com.ninaestoye.findfriends.model

import android.os.Parcelable
import androidx.room.Embedded
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Language(
    val id: Int,
    val name: String,
    @Embedded
    val countries : List<Country>
) : Parcelable