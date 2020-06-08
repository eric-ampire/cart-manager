package com.ericampire.android.cartmanager.model.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ericampire.android.cartmanager.model.entity.ProductInCart
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductInCartDao {

    @Transaction
    @Query("SELECT * FROM Product")
    fun getAllProductInCart(): Flow<List<ProductInCart>>
}