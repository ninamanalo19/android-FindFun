package com.ninaestoye.findfriends.repository

import com.ninaestoye.findfriends.api.SimpleAPI
import com.ninaestoye.findfriends.data.FriendDao
import com.ninaestoye.findfriends.model.Friend
import retrofit2.Response

class FriendRepository constructor(private val api: SimpleAPI, private val friendDao: FriendDao) {

    val getAllFriends = friendDao.getAllFriends();

    fun getFriend(id: Int) {
        friendDao.getFriend(id);
    }

    suspend fun fetchFriend(id: Int): Response<Friend> {
        return api.fetchFriend();
    }

    suspend fun fetchFriends(): Response<List<Friend>> {
        return api.fetchFriends();
    }
}