package com.kdn.stack_knowledge_android.adapter.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdn.domain.entity.student.RankingEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ItemRankingBinding

class MainPageRankingListAdapter :
    ListAdapter<RankingEntity, MainPageRankingListAdapter.RankingListViewHolder>(diffUtil) {

    inner class RankingListViewHolder(
        val context: Context,
        private val binding: ItemRankingBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ranking: Int, item: RankingEntity?) = binding.apply {
            Glide.with(ivProfile).load(item?.user?.profileImage ?: R.drawable.ic_default_profile)
            tvStudentName.text = item?.user?.name
            tvMileage.text = item?.cumulatePoint.toString()
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RankingListViewHolder =
        RankingListViewHolder(
            parent.context,
            ItemRankingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: RankingListViewHolder, position: Int) {
        holder.bind(position+1, getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RankingEntity>() {
            override fun areItemsTheSame(
                oldItem: RankingEntity,
                newItem: RankingEntity,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: RankingEntity,
                newItem: RankingEntity,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}