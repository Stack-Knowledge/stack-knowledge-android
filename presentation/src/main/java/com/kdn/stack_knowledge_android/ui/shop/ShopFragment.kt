package com.kdn.stack_knowledge_android.ui.shop

import android.view.View
import androidx.fragment.app.FragmentManager
import com.kdn.domain.model.response.GoodsResponseModel
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.shop.GoodsListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.ui.main.MainActivity
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop) {
    private lateinit var orderBottomSheet: OrderBottomSheet
    private lateinit var goodsListAdapter: GoodsListAdapter
    private lateinit var supportFragmentManager: FragmentManager
    override fun createView() {
        initRecyclerView()
        initBottomSheet()
    }

    override fun observeEvent() {
    }

    private fun initRecyclerView() {
        var testList = listOf(
            GoodsResponseModel(
                UUID.randomUUID(),
                "test",
                0,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTucUcNa1Hut31BAJWZtc-tHfEGJ40Y0fQ0br0alGCi9VW0LT23jakx6KneC5GtwEggxZM&usqp=CAU"
            )
        )
        for (i in 0..20) {
            testList = testList.plus(
                GoodsResponseModel(
                    UUID.randomUUID(),
                    "test$i",
                    i,
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTucUcNa1Hut31BAJWZtc-tHfEGJ40Y0fQ0br0alGCi9VW0LT23jakx6KneC5GtwEggxZM&usqp=CAU"
                )
            )
        }
        goodsListAdapter = GoodsListAdapter { isChecked ->
            if (isChecked) {
                binding.btnSelect.visibility = View.VISIBLE
            } else {
                binding.btnSelect.visibility = View.INVISIBLE
            }
        }
        binding.rvGoods.adapter = goodsListAdapter
        binding.rvGoods.addItemDecoration(ItemDecorator(16))
        goodsListAdapter.submitList(testList)
    }

    fun initBottomSheet() {
        orderBottomSheet = OrderBottomSheet()
        orderBottomSheet.showBottomSheet()
    }
}