package com.android.challengeroneapp.data.repository.products

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.challengeroneapp.data.db.MyShopDao
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.db.entity.ProfileEntity
import com.android.challengeroneapp.data.model.UserDetailsResponse
import com.android.challengeroneapp.db
import com.android.challengeroneapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileRepositoryImpl : ProfileRepository {

    private val apiObject = RetrofitClient.getApiObject()
    private val dao: MyShopDao = db.myShopDao()
    private val userInfo: LiveData<ProfileEntity> = dao.getProfileInfo()


    @WorkerThread
    override suspend fun saveUserProfileDetails(profileEntity: ProfileEntity) {
        dao.insertProfile(profileEntity)
    }

    @WorkerThread
    fun getUser() = userInfo

    override fun getUserProfileInfo(): LiveData<UserDetailsResponse> {
        val data = MutableLiveData<UserDetailsResponse>()
        apiObject.getUserDetails().enqueue(object : Callback<UserDetailsResponse> {

            override fun onResponse(
                call: Call<UserDetailsResponse>,
                response: Response<UserDetailsResponse>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<UserDetailsResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}
