package com.ninaestoye.findfriends.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ninaestoye.findfriends.data.FFDatabase
import com.ninaestoye.findfriends.model.Friend
import com.ninaestoye.findfriends.repository.FriendRepository

class FriendViewModel(application: Application) : AndroidViewModel(application) {

    private val friendRepository : FriendRepository
    val getAllFriends: LiveData<List<Friend>>;

    init {
        val friendDao = FFDatabase.getDatabase(application).friendDao();
        friendRepository = FriendRepository(friendDao);
        getAllFriends = friendRepository.getAllFriends;
    }

    fun getFriend(id: Int) {
        return friendRepository.getFriend(id)
    }

}