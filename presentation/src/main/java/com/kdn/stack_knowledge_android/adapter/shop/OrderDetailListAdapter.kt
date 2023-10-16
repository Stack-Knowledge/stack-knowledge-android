package com.kdn.stack_knowledge_android.adapter.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kdn.stack_knowledge_android.data.order.DetailOrderData
import com.kdn.stack_knowledge_android.databinding.ItemDetailOrderBinding

class OrderDetailListAdapter :
    ListAdapter<DetailOrderData, OrderDetailListAdapter.OrderDetailListViewHolder>(diffUtil) {

    private lateinit var countControlButtonClickListener: OnItemClickListener

    inner class OrderDetailListViewHolder(
        val context: Context,
        val binding: ItemDetailOrderBinding,
        val listener: OnItemClickListener,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DetailOrderData) = binding.apply {
            tvDetailGoodsName.text = item.name
            tvDetailGoodsPrice.text = item.price.toString()
            tvGoodsCount.text = item.count.toString()

            vPlus.setOnClickListener {
                listener.plus(item)
                tvGoodsCount.text = (tvGoodsCount.text.toString().toInt() + 1).toString()
            }

            vMinus.setOnClickListener {
                if (tvGoodsCount.text.toString().toInt() > 1) {
                    listener.minus(item)
                    tvGoodsCount.text = (tvGoodsCount.text.toString().toInt() - 1).toString()
                }
            }
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
        ),
        countControlButtonClickListener
    )

    override fun onBindViewHolder(holder: OrderDetailListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface OnItemClickListener {
        fun plus(item: DetailOrderData)
        fun minus(item: DetailOrderData)
    }

    fun setItemOnClickListener(onItemClickListener: OnItemClickListener) {
        this.countControlButtonClickListener = onItemClickListener
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DetailOrderData>() {
            override fun areItemsTheSame(
                oldItem: DetailOrderData,
                newItem: DetailOrderData
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: DetailOrderData,
                newItem: DetailOrderData
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}