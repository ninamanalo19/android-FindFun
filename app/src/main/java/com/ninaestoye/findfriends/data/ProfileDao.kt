package com.ninaestoye.findfriends.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.ninaestoye.findfriends.model.Profile

@Dao
interface ProfileDao {

    @Query("SELECT * FROM DBConstants.PROFILE_TABLE")
    fun getAllProfiles() : LiveData<List<Profile>>;

    @Query("SELECT * FROM DBConstants.PROFILE_TABLE WHERE id = :id")
    fun getProfile(id: Int) : LiveData<Profile>;

    @Update
    suspend fun updateProfile(profile: Profile)
}