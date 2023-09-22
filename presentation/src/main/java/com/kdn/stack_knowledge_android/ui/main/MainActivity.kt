package com.kdn.stack_knowledge_android.ui.main

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.MissionListAdapter
import com.kdn.stack_knowledge_android.adapter.viewpager.MainViewPagerAdapter
import com.kdn.stack_knowledge_android.databinding.ActivityMainBinding
import com.kdn.stack_knowledge_android.ui.base.BaseActivity
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main){
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this) }
    private lateinit var missionListAdapter: MissionListAdapter
    override fun createView() {
        binding.vpMainViewPager.adapter = mainViewPagerAdapter
        indicator()
        initRecyclerView()
    }

    override fun observeEvent() {

    }


    private fun indicator() {
        binding.vpMainViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.mainBannerTabLayout.getTabAt(position)?.select()
            }
        })
    }

    private fun initRecyclerView() {
        binding.rvMission.addItemDecoration(ItemDecorator(16))
    }
}