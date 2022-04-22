package com.android.challengeroneapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.challengeroneapp.R
import com.android.challengeroneapp.data.db.entity.CartEntity
import com.android.challengeroneapp.databinding.CartViewBinding
import com.android.challengeroneapp.utils.setDefaultText
import com.android.challengeroneapp.utils.setImage

class CartAdapter(
    private val itemList: List<CartEntity>,
    private val onClickListener: View.OnClickListener
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {
        val binding = DataBindingUtil.inflate<CartViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.cart_view,
            parent,
            false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = itemList[position]
        holder.binding.product = cartItem

        if (!cartItem.image.isNullOrEmpty()) {
            holder.binding.productImage.setImage(cartItem.image ?: "")
        } else {
            holder.binding.productImage.setImage(R.drawable.red_shoes)
        }

        if (cartItem.title.isNullOrEmpty()) {
            holder.binding.productName.setDefaultText(R.string.product_name)
        }

        if (cartItem.description.isNullOrEmpty()) {
            holder.binding.productDesc.setDefaultText(R.string.product_description)
        }

        if (cartItem.price.isNullOrEmpty()) {
            holder.binding.productDesc.setDefaultText(R.string.product_amount)
        }

        holder.binding.productRemoveFromCart.tag = cartItem
        holder.binding.productRemoveFromCart.setOnClickListener {
            onClickListener.onClick(it)
        }
    }

    override fun getItemCount(): Int = itemList.size

    inner class CartViewHolder(val binding: CartViewBinding) : RecyclerView.ViewHolder(binding.root)
}