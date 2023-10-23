package com.kdn.stack_knowledge_android.ui.ranking

import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.ranking.RankingPageRakingListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentRankingBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.decorator.HorizontalItemDecorator
import com.kdn.stack_knowledge_android.utils.decorator.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.ranking.MyInfoViewModel
import com.kdn.stack_knowledge_android.viewmodel.ranking.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {
    private val rankingViewModel by activityViewModels<RankingViewModel>()
    private val myInfoViewModel by activityViewModels<MyInfoViewModel>()
    private lateinit var rankingListAdapter: RankingPageRakingListAdapter

    override fun createView() {
        initRecyclerView()
        observeEvent()
    }

    override fun observeEvent() {
        repeatOnStart {
            rankingViewModel.eventFlow.collect { event -> observeRankingData(event) }
        }
        repeatOnStart {
            myInfoViewModel.eventFLow.collect { event -> observeMyInfoData(event) }
        }
    }

    private fun initRecyclerView() {
        rankingViewModel.getRankingList()
        rankingListAdapter = RankingPageRakingListAdapter()
        binding.rvRanking.adapter = rankingListAdapter
        binding.rvRanking.addItemDecoration(HorizontalItemDecorator(16))
        binding.rvRanking.addItemDecoration(VerticalItemDecorator(8))
    }

    private fun initMyInfo(data: List<MyInfoEntity>) {
        myInfoViewModel.getMyInfo()
        for (myInfoEntity in data) {
            binding.apply {
                Glide.with(ivProfile)
                    .load(myInfoEntity.user.profileImage ?: R.drawable.ic_default_profile)
                tvName.text = myInfoEntity.user.name
                tvCumulatePoint.text = myInfoEntity.cumulatePoint.toString()

                val uuid = myInfoEntity.user.id.toString()
                val itemIndex = rankingViewModel.findItemIndex(uuid, rankingListAdapter.currentList)

                itemIndex?.let { index ->
                    val ranking = rankingListAdapter.currentList[index+1].id.toString()
                    binding.tvRanking.text = ranking
                }
            }
        }
    }

    private fun observeMyInfoData(event: MyInfoViewModel.Event) = when (event) {
        is MyInfoViewModel.Event.MyInfo -> {
            initMyInfo(data = event.myInfo)
        }
    }

    private fun observeRankingData(event: RankingViewModel.Event) = when (event) {
        is RankingViewModel.Event.Ranking -> {
            rankingListAdapter.submitList(event.rankingList)
        }

        else -> {}
    }

}