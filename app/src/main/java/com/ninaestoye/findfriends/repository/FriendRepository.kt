package com.ninaestoye.findfriends.repository

import com.ninaestoye.findfriends.api.RetrofitInstance
import com.ninaestoye.findfriends.data.FriendDao
import com.ninaestoye.findfriends.model.Friend
import retrofit2.Response

class FriendRepository(private val friendDao: FriendDao) {

    val getAllFriends = friendDao.getAllFriends();

    fun getFriend(id: Int) {
        friendDao.getFriend(id);
    }

    suspend fun fetchFriend(id: Int): Response<Friend> {
        return RetrofitInstance.api.fetchFriend();
    }

    suspend fun fetchFriends(): Response<List<Friend>> {
        return RetrofitInstance.api.fetchFriends();
    }
}