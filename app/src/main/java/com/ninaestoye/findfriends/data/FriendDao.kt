package com.ninaestoye.findfriends.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.ninaestoye.findfriends.model.Friend

@Dao
interface FriendDao {
    @Query("SELECT * FROM friend_table")
    fun getAllFriends() : LiveData<List<Friend>>;

    @Query("SELECT * FROM friend_table WHERE id = :id")
    fun getFriend(id: Int) : LiveData<Friend>;
}