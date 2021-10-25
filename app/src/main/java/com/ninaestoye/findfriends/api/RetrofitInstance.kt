package com.ninaestoye.findfriends.api

import com.ninaestoye.findfriends.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    val api by lazy {
        retrofit.create(SimpleAPI::class.java);
    }
}