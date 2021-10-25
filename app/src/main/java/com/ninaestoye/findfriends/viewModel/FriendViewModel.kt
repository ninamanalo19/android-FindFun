package com.ninaestoye.findfriends.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ninaestoye.findfriends.data.FFDatabase
import com.ninaestoye.findfriends.model.Friend
import com.ninaestoye.findfriends.repository.FriendRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class FriendViewModel(application: Application) : AndroidViewModel(application) {

    private val friendRepository : FriendRepository
    val fetchFriendResponse : MutableLiveData<Response<Friend>> = MutableLiveData();
    val fetchFriendsResponse : MutableLiveData<Response<List<Friend>>> = MutableLiveData();
    val getAllFriends: LiveData<List<Friend>>;

    init {
        val friendDao = FFDatabase.getDatabase(application).friendDao();
        friendRepository = FriendRepository(friendDao);
        getAllFriends = friendRepository.getAllFriends;
    }

    fun getFriend(id: Int) {
        return friendRepository.getFriend(id)
    }

    fun fetchFriend(id: Int) {
        viewModelScope.launch {
            val response = friendRepository.fetchFriend(id);
            fetchFriendResponse.value = response;
        }
    }

    fun fetchFriends() {
        viewModelScope.launch {
            val response = friendRepository.fetchFriends();
            fetchFriendsResponse.value = response;
        }
    }

}