package com.ericampire.android.cartmanager.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryProduct (
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val productName: String,
    val productPrice: Double,
    val productId: Int
)