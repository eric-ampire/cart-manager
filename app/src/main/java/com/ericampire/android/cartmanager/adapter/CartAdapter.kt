package com.ericampire.android.cartmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ericampire.android.cartmanager.databinding.ItemCartItemBinding
import com.ericampire.android.cartmanager.model.entity.ProductInCart

class CartAdapter(val listener: CartListener) : ListAdapter<ProductInCart, CustomViewHolder>(CartAdapter) {

    companion object : DiffUtil.ItemCallback<ProductInCart>() {
        override fun areItemsTheSame(oldItem: ProductInCart, newItem: ProductInCart): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ProductInCart, newItem: ProductInCart): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartItemBinding.inflate(inflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemProductBinding = holder.binding as ItemCartItemBinding
        val currentItem = getItem(position)

        itemProductBinding.run {
            productInCart = currentItem
            btnIncrease.setOnClickListener { listener.increaseQuantity(currentItem) }
            btnDecrease.setOnClickListener { listener.descreaseQuantity(currentItem) }
            executePendingBindings()
        }
    }
}

interface CartListener {
    fun increaseQuantity(productInCart: ProductInCart)
    fun descreaseQuantity(productInCart: ProductInCart)
}