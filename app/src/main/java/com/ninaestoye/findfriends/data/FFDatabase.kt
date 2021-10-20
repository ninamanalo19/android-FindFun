package com.ninaestoye.findfriends.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ninaestoye.findfriends.model.Friend
import com.ninaestoye.findfriends.model.Profile

@Database(entities = [Profile::class, Friend::class], version = DBConstants.DATABASE_VERSION, exportSchema = false)
abstract class FFDatabase : RoomDatabase() {

    abstract fun profileDao() : ProfileDao;
    abstract fun friendDao() : FriendDao;

    companion object {
        @Volatile
        private var INSTANCE : FFDatabase? = null;

        fun getDatabase(context: Context) : FFDatabase {
            var tempInstance = INSTANCE;

            if (tempInstance != null) {
                return tempInstance;
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    FFDatabase::class.java,
                    DBConstants.DATABASE_NAME
                ).build();
                INSTANCE = instance;
                return instance;
            }
        }
    }
}