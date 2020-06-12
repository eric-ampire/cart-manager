package com.ericampire.android.cartmanager.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ericampire.android.cartmanager.model.entity.CategoryProduct
import com.ericampire.android.cartmanager.model.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryProductDao {

    @Query("SELECT * FROM CategoryProduct")
    fun getAllProducts(): Flow<List<CategoryProduct>>

    @Query("SELECT * FROM CategoryProduct WHERE id = :id")
    fun getProductById(id: Long): Flow<CategoryProduct>

    @Insert
    suspend fun insert(product: CategoryProduct)
}