package com.ninaestoye.findfun.helper

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromListString(stringList: List<String>): String {
        return stringList.joinToString();
    }

    @TypeConverter
    fun toListString(string: String) : List<String> {
        return string.split(",");
    }
}