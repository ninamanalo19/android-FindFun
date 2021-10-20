package com.ninaestoye.findfriends.repository

import com.ninaestoye.findfriends.data.FriendDao

class FriendRepository(private val friendDao: FriendDao) {

    val getAllFriends = friendDao.getAllFriends();

    fun getFriend(id: Int) {
        friendDao.getFriend(id);
    }
}