package com.android.challengeroneapp.data.repository.products

import androidx.lifecycle.LiveData
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.db.entity.ProfileEntity
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.data.model.UserDetailsResponse

interface ProfileRepository {
    fun getUserProfileInfo(): LiveData<UserDetailsResponse>

    suspend fun saveUserProfileDetails(profileEntity: ProfileEntity)
}