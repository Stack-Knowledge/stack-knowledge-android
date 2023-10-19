package com.kdn.stack_knowledge_android.ui.main

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.main.MissionListAdapter
import com.kdn.stack_knowledge_android.adapter.main.RankingListAdapter
import com.kdn.stack_knowledge_android.adapter.viewpager.MainViewPagerAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentMainBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.HorizontalItemDecorator
import com.kdn.stack_knowledge_android.utils.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this.requireContext()) }
    private lateinit var missionListAdapter: MissionListAdapter
    private lateinit var rankingListAdapter: RankingListAdapter
    private val missionViewModel by activityViewModels<MissionViewModel>()
    override fun createView() {
        showViewPager()
        initRecyclerView()
        observeEvent()
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
        missionListAdapter = MissionListAdapter().apply {
            setItemOnClickListener(object : MissionListAdapter.OnItemClickListener {
                override fun detail(item: MissionEntity?) {
                    item?.id?.let { missionViewModel.getDetailMission(it) }
                }
            })
        }
        rankingListAdapter = RankingListAdapter(listOf())
        binding.rvMission.adapter = missionListAdapter
        binding.rvRanking.adapter = rankingListAdapter
        binding.rvMission.addItemDecoration(HorizontalItemDecorator(16))
        binding.rvMission.addItemDecoration(VerticalItemDecorator(16))
        binding.rvRanking.addItemDecoration(HorizontalItemDecorator(16))
    }

    private fun observeMissionData(event: MissionViewModel.Event) = when (event) {
        is MissionViewModel.Event.Mission -> {
            missionListAdapter.submitList(event.missionList)
        }

        is MissionViewModel.Event.DetailMission -> {
            val title: String = event.detailMission.title
            val timeLimit: Int = event.detailMission.timeLimit
            val action =
                MainFragmentDirections
                    .actionMainFragmentToSolveFragment(title, timeLimit)
            findNavController()
                .navigate(action)
        }

        else -> {}
    }
}