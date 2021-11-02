package com.ninaestoye.findfriends.repository

import com.ninaestoye.findfriends.network.SimpleAPI
import com.ninaestoye.findfriends.data.ProfileDao
import com.ninaestoye.findfriends.model.Profile

class ProfileRepository constructor(private val api: SimpleAPI, private val profileDao: ProfileDao) {

    val getAllProfiles = profileDao.getAllProfiles();

    fun getProfile(id: Int) {
        profileDao.getProfile(id);
    }

    suspend fun updateProfile(profile: Profile) {
        profileDao.updateProfile(profile);
    }
}