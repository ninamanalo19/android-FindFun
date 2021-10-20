package com.ninaestoye.findfriends.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.ninaestoye.findfriends.model.Friend

@Dao
interface FriendDao {
    @Query("SELECT * FROM DBConstants.FRIEND_TABLE")
    fun getAllFriends() : LiveData<List<Friend>>;

    @Query("SELECT * FROM DBConstants.FRIEND_TABLE WHERE id = :id")
    fun getFriend(id: Int) : LiveData<Friend>;
}