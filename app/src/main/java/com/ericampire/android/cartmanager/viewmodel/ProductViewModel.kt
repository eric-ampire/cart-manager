package com.ericampire.android.cartmanager.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ericampire.android.cartmanager.model.dao.CartItemDao
import com.ericampire.android.cartmanager.model.dao.ProductDao
import com.ericampire.android.cartmanager.model.dao.ProductInCartDao
import com.ericampire.android.cartmanager.model.entity.CartItem
import com.ericampire.android.cartmanager.model.entity.Product
import com.ericampire.android.cartmanager.model.entity.ProductInCart
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class ProductViewModel : ViewModel(), KoinComponent {
    private val productDao by inject<ProductDao>()
    private val productInCartDao by inject<ProductInCartDao>()
    private val cartItemDao by inject<CartItemDao>()

    val products: LiveData<List<Product>>
        get() = productDao.getAllProducts().asLiveData()

    val productInCartItem: LiveData<List<ProductInCart>>
        get() = productInCartDao.getAllProductInCart().asLiveData()

    fun addProduct(product: Product) {
        viewModelScope.launch {
            productDao.insert(product)
        }
    }

    fun addProductToCart(product: Product) {
        viewModelScope.launch {
            val cartItem = CartItem(productId = product.id!!, productQuantity = 1)
            cartItemDao.insert(cartItem)
        }
    }

    fun increaseCartItemQuantity(productInCart: ProductInCart) {
        val oldQuantity = productInCart.cartItem?.productQuantity ?: return
        val newCartItem = productInCart.cartItem.copy(productQuantity = oldQuantity + 1)

        viewModelScope.launch {
            cartItemDao.update(newCartItem)
        }
    }

    fun decreaseCartItemQuantity(productInCart: ProductInCart) {
        val oldQuantity = productInCart.cartItem?.productQuantity ?: return
        val newCartItem = productInCart.cartItem.copy(productQuantity = oldQuantity - 1)

        viewModelScope.launch {
            cartItemDao.update(newCartItem)
        }
    }
}