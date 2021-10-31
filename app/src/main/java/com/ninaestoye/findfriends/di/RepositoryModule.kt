package com.ninaestoye.findfriends.di

import com.ninaestoye.findfriends.api.SimpleAPI
import com.ninaestoye.findfriends.data.FriendDao
import com.ninaestoye.findfriends.data.ProfileDao
import com.ninaestoye.findfriends.repository.FriendRepository
import com.ninaestoye.findfriends.repository.ProfileRepository
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
    fun provideFriendRepository(
        api: SimpleAPI,
        friendDao: FriendDao
    ): FriendRepository {
        return FriendRepository(
            api, friendDao
        );
    }

    @Singleton
    @Provides
    fun provideProfileRepository(
        api: SimpleAPI,
        profileDao: ProfileDao
    ): ProfileRepository {
        return ProfileRepository(
            api, profileDao
        );
    }
}