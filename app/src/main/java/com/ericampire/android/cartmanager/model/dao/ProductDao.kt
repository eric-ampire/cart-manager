package com.ericampire.android.cartmanager.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ericampire.android.cartmanager.model.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM Product WHERE id = :id")
    fun getProductById(id: Long): Flow<Product>

    @Insert
    suspend fun insert(product: Product)
}