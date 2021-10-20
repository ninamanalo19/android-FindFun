package com.ninaestoye.findfriends.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ninaestoye.findfriends.data.FFDatabase
import com.ninaestoye.findfriends.model.Profile
import com.ninaestoye.findfriends.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val profileRepository : ProfileRepository

    init {
        val profileDao = FFDatabase.getDatabase(application).profileDao();
        profileRepository = ProfileRepository(profileDao);

        // TODO: read profile immediately?
    }

    fun getProfile(id: Int) {
        return profileRepository.getProfile(id);
    }

    fun updateProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.updateProfile(profile);
        }
    }
}