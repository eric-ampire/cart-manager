package com.ericampire.android.cartmanager.model.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryProductInCart(
    @Embedded
    val product: CategoryProduct,

    @Relation(parentColumn = "id", entityColumn = "productId")
    val cartItem: CartItem?
)