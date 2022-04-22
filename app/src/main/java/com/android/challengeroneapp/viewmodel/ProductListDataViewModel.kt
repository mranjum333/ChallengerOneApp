package com.android.challengeroneapp.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.data.repository.products.ProductRepositoryImpl
import kotlinx.coroutines.launch

class ProductListDataViewModel(private val repository: ProductRepositoryImpl = ProductRepositoryImpl()) :
    ViewModel() {

    val allProdcuts = MediatorLiveData<List<ProductResponse>>()

    init {
        getAllProducts()
    }

    fun getAllSavedProducts() = allProdcuts

    fun getAllProducts() {
        allProdcuts.addSource(repository.getAllProducts()) {
            allProdcuts.postValue(it)
        }
    }

    fun saveItemToCart(item: ProductResponse) {
        viewModelScope.launch {
            repository.saveProductToCart(
                CartEntity(
                    item.id,
                    title = item.title,
                    price = item.price,
                    category = item.category,
                    description = item.description,
                    image = item.image
                )
            )
        }
    }
}