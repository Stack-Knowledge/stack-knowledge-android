package com.kdn.stack_knowledge_android.ui.ranking

import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.ranking.RankingPageRakingListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentRankingBinding
import com.kdn.stack_knowledge_android.databinding.ItemDetailRankingBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.ranking.MyInfoViewModel
import com.kdn.stack_knowledge_android.viewmodel.ranking.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {
    private val rankingItemBinding = ItemDetailRankingBinding.inflate(layoutInflater)
    private val rankingViewModel by viewModels<RankingViewModel>()
    private lateinit var rankingListAdapter: RankingPageRakingListAdapter
    private val myInfoViewModel by viewModels<MyInfoViewModel>()

    override fun createView() {
        initRecyclerView()
        observeEvent()
    }

    override fun observeEvent() {
        repeatOnStart {
            rankingViewModel.eventFlow.collect { event -> observeRankingData(event) }
            myInfoViewModel.eventFLow.collect { event -> observeMyInfoData(event) }
        }
    }

    private fun initRecyclerView() {
        rankingViewModel.getRankingList()
        rankingListAdapter = RankingPageRakingListAdapter().apply {
        binding.rvRanking.adapter = rankingListAdapter
        }
    }

    private fun initMyInfo(data: List<MyInfoEntity>) {
        myInfoViewModel.getMyInfo()
        for (myInfoEntity in data) {
            binding.apply {
                Glide.with(ivProfile)
                    .load(myInfoEntity.user.profileImage ?: R.drawable.ic_default_profile)
                tvName.text = myInfoEntity.user.name
                tvCumulatePoint.text = myInfoEntity.cumulatePoint.toString()
            }
        }
            binding.tvRanking.text = rankingItemBinding.tvRanking.text
    }

    private fun observeMyInfoData(event: MyInfoViewModel.Event) = when (event) {
        is MyInfoViewModel.Event.MyInfo -> {
            initMyInfo(data = event.myInfo)
        }
    }
    private fun observeRankingData(event: RankingViewModel.Event) = when (event)  {
        is RankingViewModel.Event.Ranking -> {
            rankingListAdapter.submitList(event.rankingList)
        }
        else -> {}
    }

}