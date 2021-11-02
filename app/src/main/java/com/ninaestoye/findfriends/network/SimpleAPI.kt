package com.ninaestoye.findfriends.network

import com.ninaestoye.findfriends.model.Friend
import okhttp3.Call
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleAPI {

    @GET("/data/v1/users/{id}")
    suspend fun fetchFriend(@Path("id") id: Int): Response<Friend>;

    @GET("/data/v1/user?limit=10")
    suspend fun fetchFriends() : Response<ResponseBody>;
}