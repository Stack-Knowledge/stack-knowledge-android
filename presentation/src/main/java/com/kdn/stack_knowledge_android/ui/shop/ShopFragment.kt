package com.kdn.stack_knowledge_android.ui.shop

import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop) {
    override fun createView() {
        initRecyclerView()
    }

    override fun observeEvent() {
    }

    private fun initRecyclerView() {
        binding.rvGoods.addItemDecoration(ItemDecorator(16))

    }

}