package com.kdn.stack_knowledge_android.ui.ranking

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.ranking.RankingPageRakingListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentRankingBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.ranking.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {
    private val rankingViewModel by viewModels<RankingViewModel>()
    private lateinit var rankingListAdapter: RankingPageRakingListAdapter

    override fun createView() {
        TODO("Not yet implemented")
    }

    override fun observeEvent() {
        repeatOnStart {
            rankingViewModel.eventFlow.collect { event -> observeRankingData(event)}
        }
    }

    private fun initRecyclerView() {
        rankingViewModel.getRankingList()
        rankingListAdapter = RankingPageRakingListAdapter().apply {

        }
    }

    private fun observeRankingData(event: RankingViewModel.Event) = when (event)  {
        is RankingViewModel.Event.Ranking -> {
            rankingListAdapter.submitList(event.rankingList)
        }
        else -> {}
    }
}