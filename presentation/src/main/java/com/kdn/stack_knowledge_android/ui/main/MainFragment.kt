package com.kdn.stack_knowledge_android.ui.main

import androidx.viewpager2.widget.ViewPager2
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.main.MissionListAdapter
import com.kdn.stack_knowledge_android.adapter.main.RankingListAdapter
import com.kdn.stack_knowledge_android.adapter.shop.OrderDetailListAdapter
import com.kdn.stack_knowledge_android.adapter.viewpager.MainViewPagerAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentMainBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this.requireContext()) }
    private lateinit var missionListAdapter: MissionListAdapter
    private lateinit var rankingListAdapter: RankingListAdapter
    override fun createView() {
        showViewPager()
        showIndicator()
        initRecyclerView()
    }

    override fun observeEvent() {
    }

    private fun showViewPager() {
        binding.vpMainViewPager.adapter = mainViewPagerAdapter
    }

    private fun showIndicator() {
        binding.vpMainViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.mainBannerTabLayout.getTabAt(position)?.select()
            }
        })
    }

    private fun initRecyclerView() {
        missionListAdapter = MissionListAdapter(listOf())
        rankingListAdapter = RankingListAdapter(listOf())
        binding.rvMission.adapter = missionListAdapter
        binding.rvRanking.adapter = rankingListAdapter
        binding.rvMission.addItemDecoration(ItemDecorator(16))
        binding.rvRanking.addItemDecoration(ItemDecorator(16))
    }

}