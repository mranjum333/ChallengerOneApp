package com.android.challengeroneapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val STORE_BASE_URL = "https://fakestoreapi.com"

    fun getApiObject() : MyShopApis {
        return getRetrofit().create(MyShopApis::class.java)
    }

    private fun getRetrofit() : Retrofit {
        val okHttpClient = OkHttpClient.Builder().build()
        return Retrofit.Builder()
            .baseUrl(STORE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}
