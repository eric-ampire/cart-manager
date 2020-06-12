package com.ericampire.android.cartmanager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ericampire.android.cartmanager.databinding.ItemCartItemBinding
import com.ericampire.android.cartmanager.databinding.ItemCategoryProductBinding
import com.ericampire.android.cartmanager.databinding.ItemProductBinding
import com.ericampire.android.cartmanager.model.entity.CategoryProduct
import com.ericampire.android.cartmanager.model.entity.Product

class CategoryProductAdapter(val listener: CategoryProductCartListener) : ListAdapter<CategoryProduct, CustomViewHolder>(CategoryProductAdapter) {
    companion object : DiffUtil.ItemCallback<CategoryProduct>() {
        override fun areItemsTheSame(oldItem: CategoryProduct, newItem: CategoryProduct): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CategoryProduct, newItem: CategoryProduct): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryProductBinding.inflate(inflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemProductBinding = holder.binding as ItemCategoryProductBinding
        val currentProduct = getItem(position)

        itemProductBinding.product = currentProduct
        itemProductBinding.btAddToCart.setOnClickListener { listener.addToCart(currentProduct) }
        itemProductBinding.executePendingBindings()
    }
}

interface CategoryProductCartListener {
    fun addToCart(product: CategoryProduct)
}