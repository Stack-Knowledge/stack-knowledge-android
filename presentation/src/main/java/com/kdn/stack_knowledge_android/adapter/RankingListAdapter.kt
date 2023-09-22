package com.kdn.stack_knowledge_android.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kdn.domain.model.response.RankingResponseModel
import com.kdn.stack_knowledge_android.adapter.MissionListAdapter.Companion.diffUtil

class RankingListAdapter(private val rankingList: List<RankingResponseModel>?) :
    ListAdapter<RankingResponseModel, RankingListAdapter.RankingListViewHolder(diffUtil) {
    class RankingListViewHolder(
        val context: Context,
        private val binding: Item
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RankingListAdapter.RankingListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RankingListAdapter.RankingListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}