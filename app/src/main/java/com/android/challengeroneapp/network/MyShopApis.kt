package com.android.challengeroneapp.network

import com.android.challengeroneapp.data.model.CategoryResponse
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.data.model.UserDetailsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyShopApis {

    @GET("/products")
    fun getAllProducts(): Call<List<ProductResponse>>

    @GET("/products/{id}")
    fun getProductDetails(@Query("id") id: String): Call<ProductResponse>

    @GET("/products/categories")
    fun getAllCategories(): Call<List<CategoryResponse>>

    @GET("/products/category/{category}")
    fun getCategoryProducts(category: String): Call<List<ProductResponse>>

    /*User Profile*/
    @GET("/users/1")
    fun getUserDetails(): Call<UserDetailsResponse>
}