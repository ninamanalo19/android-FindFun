package com.ninaestoye.findfun.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ninaestoye.findfun.helper.Category
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "question_table")
data class Question(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String,
    val type: String,
    val question: String,
    val correct_answer: String,
    val incorrect_answers: List<String>
) : Parcelable
