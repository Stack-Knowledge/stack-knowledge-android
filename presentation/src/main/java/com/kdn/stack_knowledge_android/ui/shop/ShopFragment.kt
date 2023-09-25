package com.kdn.stack_knowledge_android.ui.shop

import android.view.View
import android.widget.AdapterView
import android.widget.CheckedTextView
import com.kdn.domain.model.response.GoodsResponseModel
import com.kdn.domain.model.response.RankingResponseModel
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.shop.GoodsListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop) {
    private lateinit var goodsListAdapter: GoodsListAdapter
    override fun createView() {
        initRecyclerView()
    }

    override fun observeEvent() {
    }

    private fun initRecyclerView() {
        var testList = listOf(GoodsResponseModel(
            UUID.randomUUID(),
            "test",
            0,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTucUcNa1Hut31BAJWZtc-tHfEGJ40Y0fQ0br0alGCi9VW0LT23jakx6KneC5GtwEggxZM&usqp=CAU"
        ))
        for (i in 0..100) {
            testList = testList.plus(
                GoodsResponseModel(
                    UUID.randomUUID(),
                    "test$i",
                    i,
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTucUcNa1Hut31BAJWZtc-tHfEGJ40Y0fQ0br0alGCi9VW0LT23jakx6KneC5GtwEggxZM&usqp=CAU"
                )
            )
        }
        goodsListAdapter = GoodsListAdapter()
        binding.rvGoods.adapter = goodsListAdapter
        binding.rvGoods.addItemDecoration(ItemDecorator(16))
        binding.rvGoods.setOnClickListener {
            onItemClick()
        }
        goodsListAdapter.submitList(testList)
    }

    fun onItemClick() {
        val check = view as CheckedTextView
        check.isChecked = !check.isChecked
        val click = !check.isChecked
        check.isChecked = click

        if (click) {
            // click 시 bottomSheet 나오게 하기
        }
    }
}