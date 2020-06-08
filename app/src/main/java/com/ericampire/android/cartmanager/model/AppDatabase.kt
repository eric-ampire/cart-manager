package com.ericampire.android.cartmanager.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ericampire.android.cartmanager.model.dao.CartItemDao
import com.ericampire.android.cartmanager.model.dao.ProductDao
import com.ericampire.android.cartmanager.model.dao.ProductInCartDao
import com.ericampire.android.cartmanager.model.entity.CartItem
import com.ericampire.android.cartmanager.model.entity.Product

@Database(entities = [CartItem::class, Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val productInCartDao: ProductInCartDao
    abstract val productDao: ProductDao
    abstract val cartItemDao: CartItemDao
}