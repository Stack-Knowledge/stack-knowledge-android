package com.kdn.stack_knowledge_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kdn.domain.model.response.RankingResponseModel
import com.kdn.stack_knowledge_android.databinding.ItemRankingBinding

class RankingListAdapter(private val rankingList: List<RankingResponseModel>?) :
    ListAdapter<RankingResponseModel, RankingListAdapter.RankingListViewHolder>(diffUtil) {

    class RankingListViewHolder(
        val context: Context,
        private val binding: ItemRankingBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RankingResponseModel?) = binding.apply {
            tvMileage.text = item?.user?.name
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


    override fun onBindViewHolder(holder: RankingListAdapter.RankingListViewHolder, position: Int) {
        holder.bind(rankingList?.get(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RankingResponseModel>() {
            override fun areItemsTheSame(
                oldItem: RankingResponseModel,
                newItem: RankingResponseModel,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: RankingResponseModel,
                newItem: RankingResponseModel,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}