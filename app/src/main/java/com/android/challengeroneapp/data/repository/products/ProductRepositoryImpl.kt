package com.android.challengeroneapp.data.repository.products

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.challengeroneapp.data.db.MyShopDao
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.db
import com.android.challengeroneapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepositoryImpl : ProductRepository {

    private val apiObject = RetrofitClient.getApiObject()
    private val productsDao: MyShopDao = db.myShopDao()
    private val productsList: LiveData<List<ProductResponse>> = productsDao.getAll()

    @WorkerThread
    suspend fun saveProductToTable(productResponse: ProductResponse) {
        productsDao.insert(productResponse)
    }

    @WorkerThread
    suspend fun saveProductToCart(cartItem: CartEntity) {
        productsDao.insertToCart(cartItem)
    }

    @WorkerThread
    fun getAllProductsFromDb() = productsList

    override fun getAllProducts() : LiveData<List<ProductResponse>> {
        val data = MutableLiveData<List<ProductResponse>>()
        apiObject.getAllProducts().enqueue(object : Callback<List<ProductResponse>> {
            override fun onResponse(
                call: Call<List<ProductResponse>>,
                response: Response<List<ProductResponse>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<ProductResponse>>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }

    override fun getProductById(id: String): LiveData<ProductResponse> {
        val data = MutableLiveData<ProductResponse>()
        apiObject.getProductDetails(id).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>

            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}