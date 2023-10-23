package com.kdn.stack_knowledge_android.adapter.ranking

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdn.domain.entity.student.RankingEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ItemDetailRankingBinding

class RankingPageRakingListAdapter :
ListAdapter<RankingEntity, RankingPageRakingListAdapter.RankingListViewHolder>(diffUtil) {

    inner class RankingListViewHolder(
        val context: Context,
        private val binding: ItemDetailRankingBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ranking: Int, item: RankingEntity) = binding.apply {
            Glide.with(ivProfile).load(item.user.profileImage ?: R.drawable.ic_default_profile )
            tvName.text = item.user.name
            tvCurrentPoint.text = item.cumulatePoint.toString()
            tvRanking.text = ranking.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RankingListViewHolder =
        RankingListViewHolder(
            parent.context,
            ItemDetailRankingBinding.inflate(
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