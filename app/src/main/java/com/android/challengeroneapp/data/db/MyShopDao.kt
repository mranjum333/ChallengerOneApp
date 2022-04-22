package com.android.challengeroneapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.db.entity.ProfileEntity
import com.android.challengeroneapp.data.model.ProductResponse

@Dao
interface MyShopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(products: ProductResponse)

    @Query("select * from productresponse")
    fun getAll(): LiveData<List<ProductResponse>>

    @Query("select * FROM productresponse WHERE id = :id")
    fun getProductById(id: Int?): ProductResponse

    /*Cart*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertToCart(item: CartEntity)

    @Query("select * from cartentity")
    fun getAllCartItems(): LiveData<List<CartEntity>>

    @Delete
    suspend fun deleteItem(item: CartEntity)

    /*User*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertProfile(item: ProfileEntity)

    @Query("select * from profileentity")
    fun getProfileInfo(): LiveData<ProfileEntity>

}