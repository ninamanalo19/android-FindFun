package com.ninaestoye.findfriends.repository

import com.google.gson.Gson
import com.ninaestoye.findfriends.network.SimpleAPI
import com.ninaestoye.findfriends.data.FriendDao
import com.ninaestoye.findfriends.model.Friend
import okhttp3.ResponseBody
import retrofit2.Response

class FriendRepository constructor(private val api: SimpleAPI, private val friendDao: FriendDao) {

    val getAllFriends = friendDao.getAllFriends();

    fun getFriend(id: Int) {
        friendDao.getFriend(id);
    }

    suspend fun fetchFriend(id: Int): Response<Friend> {
        return api.fetchFriend(id);
    }

    suspend fun fetchFriends() {

        val response : Response<ResponseBody> = api.fetchFriends();
        if (response.isSuccessful) {
            val responseBody = response.body();
            responseBody.let { body ->

            }
        }

    }
}