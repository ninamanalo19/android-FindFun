package com.ninaestoye.findfun.di

import android.content.Context
import androidx.room.Room
import com.ninaestoye.findfun.MainApplication
import com.ninaestoye.findfun.data.DBConstants
import com.ninaestoye.findfun.data.FFDatabase
import com.ninaestoye.findfun.data.QuestionDao
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
    fun provideQuestionDao(ffDatabase: FFDatabase): QuestionDao {
        return ffDatabase.questionDao();
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