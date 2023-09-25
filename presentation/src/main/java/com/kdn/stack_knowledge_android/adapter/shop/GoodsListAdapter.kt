package com.kdn.stack_knowledge_android.adapter.shop

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kdn.domain.model.response.GoodsResponseModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.databinding.ItemGoodsBinding

class GoodsListAdapter(private val onCheckBoxClickListener: (Boolean) -> Unit) :
    ListAdapter<GoodsResponseModel, GoodsListAdapter.GoodsListViewHolder>(diffUtil) {

    inner class GoodsListViewHolder(
        val context: Context,
        private val binding: ItemGoodsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GoodsResponseModel) = binding.apply {
            Glide.with(context).load(item.image).into(ivGoods)
            tvGoodsName.text = item.name
            tvPrice.text = item.price.toString()
            checkbox.setOnClickListener {
                onCheckBoxClickListener(checkbox.isChecked)
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