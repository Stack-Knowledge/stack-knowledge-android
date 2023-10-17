package com.kdn.stack_knowledge_android.adapter.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kdn.domain.model.response.RankingResponseModel
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ItemRankingBinding

class RankingListAdapter(private val rankingList: List<RankingResponseModel>?) :
    ListAdapter<RankingResponseModel, RankingListAdapter.RankingListViewHolder>(diffUtil) {

    class RankingListViewHolder(
        val context: Context,
        private val binding: ItemRankingBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ranking: Int, item: RankingResponseModel?) = binding.apply {
            when(ranking) {
                1 -> {
                    // 1등일때 View 바꾸기
                }
                2 -> {
                    // 2등일때 View 바꾸기
                }
                3 -> {
                    // 3등일때 View 바꾸기
                }
                else -> {}
            }
            Glide.with(ivProfile).load(item?.user?.profileImage ?: R.drawable.ic_default_profile)
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


    override fun onBindViewHolder(holder: RankingListViewHolder, position: Int) {
        holder.bind(position+1,rankingList?.get(position))
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