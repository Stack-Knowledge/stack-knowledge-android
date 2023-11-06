package com.kdn.stack_knowledge_android.adapter.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdn.domain.entity.order.OrderedItemEntity
import com.kdn.stack_knowledge_android.adapter.mission.MissionPageMissionListAdapter
import com.kdn.stack_knowledge_android.databinding.ItemOrderedItemBinding

class OrderedItemListAdapter :
    ListAdapter<OrderedItemEntity, OrderedItemListAdapter.OrderedItemListViewHolder>(diffUtil) {
    private lateinit var itemClickListener: OnItemClickListener

    inner class OrderedItemListViewHolder(
        val context: Context,
        private val binding: ItemOrderedItemBinding,
        private val listener: OnItemClickListener,
        ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OrderedItemEntity) = binding.apply {
            Glide.with(context).load(item.item.image).into(ivOrderedItem)
            tvItemName.text = item.item.name
            tvPrice.text = item.price.toString()
            tvStudentName.text = item.user.name
            tvCount.text = item.count.toString()
            orderedItemLayout.setOnClickListener {
                listener.onItemClick(item)
            }

        }
    }


    interface OnItemClickListener {
        fun onItemClick(item: OrderedItemEntity)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): OrderedItemListViewHolder = OrderedItemListViewHolder(
        parent.context,
        ItemOrderedItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        itemClickListener
    )

    override fun onBindViewHolder(holder: OrderedItemListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<OrderedItemEntity>() {
            override fun areItemsTheSame(
                oldItem: OrderedItemEntity,
                newItem: OrderedItemEntity,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: OrderedItemEntity,
                newItem: OrderedItemEntity,
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}