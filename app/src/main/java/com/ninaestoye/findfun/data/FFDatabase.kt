package com.ninaestoye.findfun.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ninaestoye.findfun.helper.Converters
import com.ninaestoye.findfun.model.Question

@Database(entities = [Question::class], version = DBConstants.DATABASE_VERSION, exportSchema = false)
@TypeConverters(Converters::class)
abstract class FFDatabase : RoomDatabase() {
    abstract fun questionDao() : QuestionDao;
}