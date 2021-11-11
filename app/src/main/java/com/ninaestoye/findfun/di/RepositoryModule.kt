package com.ninaestoye.findfun.di

import com.ninaestoye.findfun.data.QuestionDao
import com.ninaestoye.findfun.network.SimpleAPI
import com.ninaestoye.findfun.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideQuestionRepository(
        api: SimpleAPI,
        questionDao: QuestionDao
    ): QuestionRepository {
        return QuestionRepository(
            api, questionDao
        );
    }
}