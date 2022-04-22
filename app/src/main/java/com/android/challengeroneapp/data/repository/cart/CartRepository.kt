package com.android.challengeroneapp.data.repository.cart

import androidx.lifecycle.LiveData
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.model.ProductResponse

interface CartRepository {

    fun getAllProductsInCart(): LiveData<List<CartEntity>>

}