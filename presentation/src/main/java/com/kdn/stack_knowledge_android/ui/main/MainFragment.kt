package com.kdn.stack_knowledge_android.ui.main

import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.main.MissionListAdapter
import com.kdn.stack_knowledge_android.adapter.main.RankingListAdapter
import com.kdn.stack_knowledge_android.adapter.viewpager.MainViewPagerAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentMainBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import com.kdn.stack_knowledge_android.viewmodel.shop.ItemListVewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this.requireContext()) }
    private lateinit var missionListAdapter: MissionListAdapter
    private lateinit var rankingListAdapter: RankingListAdapter
    private val missionViewModel by viewModels<MissionViewModel>()
    override fun createView() {
        showViewPager()
        initRecyclerView()
    }

    override fun observeEvent() {
        repeatOnStart {
            missionViewModel.eventFlow.collect { event -> observeMissionData(event) }
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
        missionListAdapter = MissionListAdapter(listOf())
        rankingListAdapter = RankingListAdapter(listOf())
        binding.rvMission.adapter = missionListAdapter
        binding.rvRanking.adapter = rankingListAdapter
        binding.rvMission.addItemDecoration(ItemDecorator(16))
        binding.rvRanking.addItemDecoration(ItemDecorator(16))
    }

    private fun observeMissionData(event: MissionViewModel.Event) = when (event) {
        is MissionViewModel.Event.Mission -> {
            missionListAdapter.submitList(event.missionList)
        }
    }
}