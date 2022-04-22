package com.android.challengeroneapp.data.repository.cart

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.android.challengeroneapp.data.db.MyShopDao
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.db

class CartRepositoryImpl : CartRepository {

    private val myShopDao: MyShopDao = db.myShopDao()
    private val cartList: LiveData<List<CartEntity>> = myShopDao.getAllCartItems()

    @WorkerThread
    override fun getAllProductsInCart(): LiveData<List<CartEntity>> = cartList

    @WorkerThread
    suspend fun removeItemFromCart(item: CartEntity) {
        myShopDao.deleteItem(item)
    }
}