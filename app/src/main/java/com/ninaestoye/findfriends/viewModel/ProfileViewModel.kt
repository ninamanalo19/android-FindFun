package com.ninaestoye.findfriends.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninaestoye.findfriends.model.Profile
import com.ninaestoye.findfriends.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val profileRepository: ProfileRepository) : ViewModel() {

    fun getProfile(id: Int) {
        return profileRepository.getProfile(id);
    }

    fun updateProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.updateProfile(profile);
        }
    }
}