package com.ericampire.android.cartmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ericampire.android.cartmanager.databinding.ItemProductBinding
import com.ericampire.android.cartmanager.model.entity.Product

class ProductAdapter(val listener: ProductCartListener) : ListAdapter<Product, CustomViewHolder>(ProductAdapter) {
    companion object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemProductBinding = holder.binding as ItemProductBinding
        val currentProduct = getItem(position)

        itemProductBinding.product = currentProduct
        itemProductBinding.btAddToCart.setOnClickListener { listener.addToCart(currentProduct) }
        itemProductBinding.executePendingBindings()
    }
}

interface ProductCartListener {
    fun addToCart(product: Product)
}