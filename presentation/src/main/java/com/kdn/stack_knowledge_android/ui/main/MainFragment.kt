package com.kdn.stack_knowledge_android.ui.main

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.main.MissionListAdapter
import com.kdn.stack_knowledge_android.adapter.main.MainPageRankingListAdapter
import com.kdn.stack_knowledge_android.adapter.viewpager.MainViewPagerAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentMainBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.HorizontalItemDecorator
import com.kdn.stack_knowledge_android.utils.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import com.kdn.stack_knowledge_android.viewmodel.ranking.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.UUID

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this.requireContext()) }
    private lateinit var missionListAdapter: MissionListAdapter
    private lateinit var rankingListAdapter: MainPageRankingListAdapter
    private val missionViewModel by activityViewModels<MissionViewModel>()
    private val rankingViewModel by viewModels<RankingViewModel>()
    override fun createView() {
        showViewPager()
        initRecyclerView()
        observeEvent()
    }

    override fun observeEvent() {
        repeatOnStart {
            missionViewModel.eventFlow.collect { event -> observeMissionData(event) }
            rankingViewModel.eventFlow.collect { event -> observeRankingData(event) }
        }
    }

    private fun showViewPager() {
        binding.vpMainViewPager.adapter = mainViewPagerAdapter
        binding.vpMainViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.mainBannerTabLayout.getTabAt(position)?.select()
            }
        })
    }

    private fun initRecyclerView() {
        missionViewModel.getMissionList()
        rankingViewModel.getRankingList()
        missionListAdapter = MissionListAdapter().apply {
            setItemOnClickListener(object : MissionListAdapter.OnItemClickListener {
                override fun detail(item: MissionEntity?) {
                    item?.id?.let { missionViewModel.getDetailMission(it) }
                }
            })
        }
        rankingListAdapter = MainPageRankingListAdapter()
        binding.rvMission.adapter = missionListAdapter
        binding.rvRanking.adapter = rankingListAdapter
        binding.rvMission.addItemDecoration(HorizontalItemDecorator(16))
        binding.rvMission.addItemDecoration(VerticalItemDecorator(16))
        binding.rvRanking.addItemDecoration(HorizontalItemDecorator(16))
        binding.rvRanking.addItemDecoration(VerticalItemDecorator(16))
    }

    private fun observeRankingData(event: RankingViewModel.Event) = when (event) {
        is RankingViewModel.Event.Ranking -> {
            rankingListAdapter.submitList(event.rankingList)
        }
        else -> {}
    }
    private fun observeMissionData(event: MissionViewModel.Event) = when (event) {
        is MissionViewModel.Event.Mission -> {
            missionListAdapter.submitList(event.missionList)
        }

        is MissionViewModel.Event.DetailMission -> {
            val title: String = event.detailMission.title
            val timeLimit: Int = event.detailMission.timeLimit
            val missionId: UUID = event.missionId
            val action =
                MainFragmentDirections
                    .actionMainFragmentToSolveFragment(missionId.toString(), title, timeLimit)
            findNavController()
                .navigate(action)
        }

        else -> {}
    }
}