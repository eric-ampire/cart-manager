package com.ericampire.android.cartmanager.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ericampire.android.cartmanager.R
import com.ericampire.android.cartmanager.adapter.CartAdapter
import com.ericampire.android.cartmanager.adapter.CartListener
import com.ericampire.android.cartmanager.model.entity.ProductInCart
import com.ericampire.android.cartmanager.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_cart.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CartFragment : Fragment(), CartListener {

    private val viewModel by viewModel<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cartAdapter = CartAdapter(this)
        view.rvListCartItem.adapter = cartAdapter

        viewModel.productInCartItem.observe(viewLifecycleOwner, Observer { cartItem ->
            val data = cartItem.filter { it.cartItem != null }
            data.let(cartAdapter::submitList)
        })
    }

    override fun increaseQuantity(productInCart: ProductInCart) {
        viewModel.increaseCartItemQuantity(productInCart)
    }

    override fun descreaseQuantity(productInCart: ProductInCart) {
        viewModel.decreaseCartItemQuantity(productInCart)
    }
}