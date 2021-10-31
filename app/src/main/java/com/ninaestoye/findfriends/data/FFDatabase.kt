package com.ninaestoye.findfriends.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ninaestoye.findfriends.model.Friend
import com.ninaestoye.findfriends.model.Profile

@Database(entities = [Profile::class, Friend::class], version = DBConstants.DATABASE_VERSION, exportSchema = false)
abstract class FFDatabase : RoomDatabase() {
    abstract fun profileDao() : ProfileDao;
    abstract fun friendDao() : FriendDao;
}