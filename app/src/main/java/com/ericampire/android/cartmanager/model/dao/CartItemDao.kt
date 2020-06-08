package com.ericampire.android.cartmanager.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ericampire.android.cartmanager.model.entity.CartItem

@Dao
interface CartItemDao {

    @Insert
    suspend fun insert(cartItem: CartItem)

//    @Query("SELECT * FROM CartItem WHERE cartItemId = :id")
//    suspend fun getById(id: Long): CartItem

    @Update
    suspend fun update(newCartItem: CartItem)
}