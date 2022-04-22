package com.android.challengeroneapp.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.challengeroneapp.data.db.entity.ProfileEntity
import com.android.challengeroneapp.data.repository.products.ProfileRepositoryImpl
import com.android.challengeroneapp.data.model.UserDetailsResponse
import kotlinx.coroutines.launch

class ProfileDataViewModel(private val repository: ProfileRepositoryImpl = ProfileRepositoryImpl()) :
    ViewModel() {

    val userProfileData = MediatorLiveData<List<ProfileEntity>>()

    init {
        getUserProfile()
    }

    fun getProfileData() = userProfileData

    fun getUserProfile() {
        userProfileData.addSource(repository.getUserProfileInfo()) {
            viewModelScope.launch {
                saveUserInfoToDb(it)
            }
        }
    }

    suspend fun saveUserInfoToDb(user: UserDetailsResponse) {
        repository.saveUserProfileDetails(
            ProfileEntity(
                id = user.id,
                firstName = user.name?.firstName,
                lastName = user.name?.firstName,
                city = user.address?.city,
                country = user.address?.number,
                phoneNumber = user.phone,
                email = user.email
            )
        )
        getUserInfo()
    }

    fun getUserInfo() {
        userProfileData.addSource(repository.getUser()) {
            userProfileData.postValue(listOf(it))
        }
    }
}