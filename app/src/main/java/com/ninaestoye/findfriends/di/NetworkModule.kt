package com.ninaestoye.findfriends.di

import com.ninaestoye.findfriends.api.SimpleAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAPI(): SimpleAPI {
        return Retrofit.Builder()
            .baseUrl(SimpleAPI.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SimpleAPI::class.java);
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String {
        return "Token"
    }
}