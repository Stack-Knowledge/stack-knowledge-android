package com.kdn.stack_knowledge_android.adapter.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdn.domain.entity.item.ItemEntity
import com.kdn.stack_knowledge_android.databinding.ItemGoodsBinding

class ItemListAdapter(private val onCheckBoxClickListener: (Boolean, ItemEntity) -> Unit) :
    ListAdapter<ItemEntity, ItemListAdapter.GoodsListViewHolder>(diffUtil) {

    inner class GoodsListViewHolder(
        val context: Context,
        private val binding: ItemGoodsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemEntity) = binding.apply {
            Glide.with(context).load(item.image).into(ivGoods)
            tvGoodsName.text = item.name
            tvPrice.text = item.price.toString()
            checkbox.setOnClickListener {
                onCheckBoxClickListener(checkbox.isChecked, item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): GoodsListViewHolder = GoodsListViewHolder(
        parent.context,
        ItemGoodsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: GoodsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ItemEntity>() {
            override fun areItemsTheSame(
                oldItem: ItemEntity,
                newItem: ItemEntity
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ItemEntity,
                newItem: ItemEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}