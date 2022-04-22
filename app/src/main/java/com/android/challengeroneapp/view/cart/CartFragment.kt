package com.android.challengeroneapp.view.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.challengeroneapp.R
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.view.adapter.CartAdapter
import com.android.challengeroneapp.view.adapter.ProductListAdapter
import com.android.challengeroneapp.viewmodel.CartDataViewModel
import com.android.challengeroneapp.viewmodel.ProductListDataViewModel
import kotlinx.coroutines.launch

class CartFragment : Fragment() {

    private lateinit var viewModel: CartDataViewModel
    private val productList = mutableListOf<CartEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CartAdapter(productList, onItemClickListener)
        val textView = view.findViewById<TextView>(R.id.cartErrorMsg)
        val recyclerview = view.findViewById<RecyclerView>(R.id.cartListView)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = adapter

        viewModel =  ViewModelProvider(this).get(CartDataViewModel::class.java)
        viewModel.getAllCartItems().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.isNullOrEmpty()) {
                    textView.visibility = View.VISIBLE
                } else {
                    productList.addAll(it)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

    private val onItemClickListener = object: View.OnClickListener {
        override fun onClick(itemView: View?) {
            val item = itemView?.tag as CartEntity
            viewModel.removeItemFromCart(item)
        }
    }
}