package com.ninaestoye.findfriends.api

import com.ninaestoye.findfriends.model.Friend
import com.ninaestoye.findfriends.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface SimpleAPI {

    companion object {
        const val BASEURL = Constants.BASE_URL;
    }

    @GET("/users/1")
    suspend fun fetchFriend(): Response<Friend>;

    @GET("/users")
    suspend fun fetchFriends(): Response<List<Friend>>;
}