package com.ericampire.android.cartmanager.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.ericampire.android.cartmanager.R
import com.ericampire.android.cartmanager.model.entity.Product
import com.ericampire.android.cartmanager.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_add_product.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddProductFragment : Fragment() {

    private val viewModel by viewModel<ProductViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnAddProduct.setOnClickListener {
            val productName = view.edProductName.text.toString().trim()
            val productPrice = view.edProductPrice.text.toString().toDouble()

            val product = Product(
                productName = productName,
                productPrice = productPrice
            )

            viewModel.addProduct(product)
            it.findNavController().navigateUp()
        }
    }
}