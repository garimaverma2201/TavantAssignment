package com.app.tanvant.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.app.tanvant.databinding.ProductListLayoutAdapterBinding
import com.app.tanvant.fragment.HomeFragmentDirections
import com.app.tanvant.model.ProductResponse

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    inner class ProductListViewHolder(val binding : ProductListLayoutAdapterBinding) :
            RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<ProductResponse>(){
        override fun areItemsTheSame(oldItem: ProductResponse, newItem: ProductResponse): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ProductResponse, newItem: ProductResponse): Boolean {
           return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var productList : List<ProductResponse>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(
            ProductListLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount() = productList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
       val product = productList[position]

        holder.binding.apply {
            productTitle.text = product.title
            rating.rating = product.rating.rate.toFloat()
            productPrice.text = "₹ ${product.price.toString()}"
            productImage.load(product.image) {
                crossfade(true)
                crossfade(1000)
            }
            ratingCount.text = "(${product.rating.count.toString()})"
        }

        holder.itemView.setOnClickListener{mView->
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment2(product)
            mView.findNavController().navigate(direction)
        }
    }


}