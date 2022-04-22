package com.android.challengeroneapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.challengeroneapp.R
import com.android.challengeroneapp.data.model.ProductResponse
import com.android.challengeroneapp.databinding.ProductListViewBinding
import com.android.challengeroneapp.utils.setDefaultText
import com.android.challengeroneapp.utils.setImage

class ProductListAdapter(
    private val listView: List<ProductResponse>,
    private val onClickListener: View.OnClickListener
) : RecyclerView.Adapter<ProductListAdapter.DataViewHolder>() {

    private lateinit var dataViewHolder: DataViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataBindingUtil
            .inflate<ProductListViewBinding>(
                LayoutInflater.from(parent.context),
                R.layout.product_list_view,
                parent,
                false
            )
        dataViewHolder = DataViewHolder(binding)
        return dataViewHolder
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val product = listView[position]
        holder.binding.product = product
        holder.binding.productAddToCart.tag = product
        holder.binding.productAddToCart.setOnClickListener {
            onClickListener.onClick(it)
        }

        if (!product.image.isNullOrEmpty()) {
            holder.binding.productImage.setImage(product.image ?: "")
        } else {
            holder.binding.productImage.setImage(R.drawable.red_shoes)
        }

        if (product.title.isNullOrEmpty()) {
            holder.binding.productName.setDefaultText(R.string.product_name)
        }

        if (product.description.isNullOrEmpty()) {
            holder.binding.productDesc.setDefaultText(R.string.product_description)
        }

        if (product.price.isNullOrEmpty()) {
            holder.binding.productDesc.setDefaultText(R.string.product_amount)
        }
    }

    override fun getItemCount(): Int = listView.size

    inner class DataViewHolder(val binding: ProductListViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}