package com.ninaestoye.findfriends.di

import android.content.Context
import androidx.room.Room
import com.ninaestoye.findfriends.MainApplication
import com.ninaestoye.findfriends.data.DBConstants
import com.ninaestoye.findfriends.data.FFDatabase
import com.ninaestoye.findfriends.data.FriendDao
import com.ninaestoye.findfriends.data.ProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): MainApplication {
        return app as MainApplication;
    }

    @Singleton
    @Provides
    fun provideFriendDao(ffDatabase: FFDatabase): FriendDao {
        return ffDatabase.friendDao();
    }

    @Singleton
    @Provides
    fun provideProfileDao(ffDatabase: FFDatabase) : ProfileDao {
        return ffDatabase.profileDao();
    }

    @Singleton
    @Provides
    fun provideDatabase(application: MainApplication) : FFDatabase {
        return Room.databaseBuilder(
            application,
            FFDatabase::class.java,
            DBConstants.DATABASE_NAME
        ).build();
    }
}