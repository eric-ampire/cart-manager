package com.ericampire.android.cartmanager.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.ericampire.android.cartmanager.R
import com.ericampire.android.cartmanager.adapter.CartAdapter
import com.ericampire.android.cartmanager.adapter.ProductAdapter
import com.ericampire.android.cartmanager.adapter.ProductCartListener
import com.ericampire.android.cartmanager.model.entity.Product
import com.ericampire.android.cartmanager.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_cart.view.*
import kotlinx.android.synthetic.main.list_product_fragment.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListProductFragment : Fragment(), ProductCartListener {

    private val viewModel by viewModel<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_product_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnAddProduct.setOnClickListener {
            val action = R.id.action_listProductFragment_to_addProductFragment
            it.findNavController().navigate(action)
        }

        view.btnCart.setOnClickListener {
            val action = R.id.action_listProductFragment_to_cartFragment
            it.findNavController().navigate(action)
        }

        view.btnCategory.setOnClickListener {
            val action = R.id.action_listProductFragment_to_listCategoryProductFragment
            it.findNavController().navigate(action)
        }

        setupRecyclerViewAdapter(view)
    }

    private fun setupRecyclerViewAdapter(createdView: View) {
        val productAdapter = ProductAdapter(this)
        createdView.rvListProduct.adapter = productAdapter

        viewModel.products.observe(viewLifecycleOwner, Observer {
            it.let(productAdapter::submitList)
        })
    }

    override fun addToCart(product: Product) {
        viewModel.addProductToCart(product)
        Toast.makeText(context, "Added", Toast.LENGTH_LONG).show()
    }
}