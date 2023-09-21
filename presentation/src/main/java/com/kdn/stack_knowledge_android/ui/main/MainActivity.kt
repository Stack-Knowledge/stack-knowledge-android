package com.kdn.stack_knowledge_android.ui.main

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.viewpager.MainViewPagerAdapter
import com.kdn.stack_knowledge_android.databinding.ActivityMainBinding
import com.kdn.stack_knowledge_android.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main){
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this) }
    override fun createView() {
        binding.vpMainViewPager.adapter = mainViewPagerAdapter
        indicator()
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

}