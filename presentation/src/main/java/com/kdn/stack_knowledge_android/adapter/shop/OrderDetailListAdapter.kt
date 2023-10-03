package com.kdn.stack_knowledge_android.adapter.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kdn.stack_knowledge_android.databinding.ItemDetailOrderBinding

class OrderDetailListAdapter(private val context: Context) :
    ListAdapter<GoodsResponseModel, OrderDetailListAdapter.OrderDetailListViewHolder>(diffUtil) {
    class OrderDetailListViewHolder(
        val context: Context,
        val binding: ItemDetailOrderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GoodsResponseModel) = binding.apply{
            tvDetailGoodsName.text = item.name
            tvDetailGoodsPrice.text = item.price.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderDetailListViewHolder = OrderDetailListViewHolder(
        parent.context,
        ItemDetailOrderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: OrderDetailListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<GoodsResponseModel>() {
            override fun areItemsTheSame(
                oldItem: GoodsResponseModel,
                newItem: GoodsResponseModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GoodsResponseModel,
                newItem: GoodsResponseModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}