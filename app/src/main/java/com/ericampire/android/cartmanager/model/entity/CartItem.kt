package com.ericampire.android.cartmanager.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartItem (
    @PrimaryKey(autoGenerate = true)
    val cartItemId: Long? = null,
    val productQuantity: Long,
    val productId: Long
)