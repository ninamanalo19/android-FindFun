package com.ninaestoye.findfriends.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninaestoye.findfriends.model.Friend
import com.ninaestoye.findfriends.repository.FriendRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class FriendViewModel @Inject constructor(private val friendRepository : FriendRepository, private @Named("auth_token") val token: String) : ViewModel() {

    val fetchFriendResponse : MutableLiveData<Response<Friend>> = MutableLiveData();
    val fetchFriendsResponse : MutableLiveData<Response<List<Friend>>> = MutableLiveData();
    val getAllFriends: LiveData<List<Friend>>;

    init {
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