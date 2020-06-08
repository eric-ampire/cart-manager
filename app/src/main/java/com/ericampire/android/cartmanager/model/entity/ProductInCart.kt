package com.ericampire.android.cartmanager.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProductInCart(
    @Embedded
    val product: Product,

    @Relation(parentColumn = "id", entityColumn = "productId")
    val cartItem: CartItem?
)