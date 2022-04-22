package com.android.challengeroneapp.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.repository.cart.CartRepositoryImpl
import kotlinx.coroutines.launch

class CartDataViewModel(private val repository: CartRepositoryImpl = CartRepositoryImpl()) :
    ViewModel() {

    val allProdcuts = MediatorLiveData<List<CartEntity>>()

    init {
        getAllProductsFromDb()
    }

    var cartsLiveData: MutableLiveData<List<CartEntity>>? = null

    fun getAllCartItems() = allProdcuts

    fun getAllProductsFromDb() {
        allProdcuts.addSource(repository.getAllProductsInCart()) {
            allProdcuts.postValue(it)
        }
    }

    fun removeItemFromCart(item: CartEntity) {
        viewModelScope.launch {
            repository.removeItemFromCart(item)
        }
    }
}