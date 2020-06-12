package com.ericampire.android.cartmanager.view.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.ericampire.android.cartmanager.R
import com.ericampire.android.cartmanager.adapter.CategoryProductAdapter
import com.ericampire.android.cartmanager.adapter.CategoryProductCartListener
import com.ericampire.android.cartmanager.model.entity.CategoryProduct
import com.ericampire.android.cartmanager.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.list_category_product_fragment.view.*
import kotlinx.android.synthetic.main.list_product_fragment.view.btnAddProduct
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListCategoryProductFragment : Fragment(), CategoryProductCartListener {

    private val viewModel by viewModel<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_category_product_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnAddProduct.setOnClickListener {
//            val action = R.id.action_listProductFragment_to_addProductFragment
            val action = R.id.action_listCategoryProductFragment_to_addCategroyProductFragment
            it.findNavController().navigate(action)
        }


        setupRecyclerViewAdapter(view)
    }

    private fun setupRecyclerViewAdapter(createdView: View) {
        val productAdapter = CategoryProductAdapter(this)
        createdView.rvListCategoryProduct.adapter = productAdapter

        viewModel.categoryProducts.observe(viewLifecycleOwner, Observer {
            it.let(productAdapter::submitList)
        })
    }

    override fun addToCart(product: CategoryProduct) {
        viewModel.addCategpryProductToCart(product)
        Toast.makeText(context, "Added", Toast.LENGTH_LONG).show()
    }

}