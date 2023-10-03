package com.kdn.stack_knowledge_android.adapter.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdn.domain.entity.GoodsEntity
import com.kdn.stack_knowledge_android.databinding.ItemGoodsBinding

class GoodsListAdapter(private val onCheckBoxClickListener: (Boolean, GoodsEntity) -> Unit) :
    ListAdapter<GoodsEntity, GoodsListAdapter.GoodsListViewHolder>(diffUtil) {

    inner class GoodsListViewHolder(
        val context: Context,
        private val binding: ItemGoodsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GoodsEntity) = binding.apply {
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
        val diffUtil = object : DiffUtil.ItemCallback<GoodsEntity>() {
            override fun areItemsTheSame(
                oldItem: GoodsEntity,
                newItem: GoodsEntity
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: GoodsEntity,
                newItem: GoodsEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}