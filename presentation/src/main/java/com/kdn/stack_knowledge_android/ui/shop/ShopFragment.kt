package com.kdn.stack_knowledge_android.ui.shop

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.kdn.domain.entity.GoodsEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.shop.GoodsListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.ui.main.MainActivity
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.shop.GoodsListVewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.UUID

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop) {
    private lateinit var orderBottomSheet: OrderBottomSheet
    private lateinit var goodsListAdapter: GoodsListAdapter
    private lateinit var supportFragmentManager: FragmentManager
    private lateinit var mainActivity: MainActivity
    private val goodsListViewModel by viewModels<GoodsListVewModel>()
    private var selectedGoodsList: MutableList<GoodsEntity> = mutableListOf()

    override fun createView() {
        initRecyclerView()
        initBottomSheet()
    }

    override fun observeEvent() {
        repeatOnStart {
            goodsListViewModel.eventFlow.collect { event -> observeGoodsData(event) }
        }
    }

    private fun initRecyclerView() {
        goodsListViewModel.getGoodsList()
        goodsListAdapter = GoodsListAdapter { isChecked, goodsEntity ->
            if (isChecked) {
                selectedGoodsList.add(goodsEntity)
            } else {
                selectedGoodsList.remove(goodsEntity)
            }
            binding.btnSelect.isVisible = selectedGoodsList.isNotEmpty()
        }
        binding.rvGoods.adapter = goodsListAdapter
        binding.rvGoods.addItemDecoration(ItemDecorator(16))

    }

    private fun observeGoodsData(event: GoodsListVewModel.Event) = when (event) {
        is GoodsListVewModel.Event.Goods -> {
            goodsListAdapter.submitList(event.goodsList)
        }
    }

    private fun initBottomSheet() {
        orderBottomSheet = OrderBottomSheet()
        binding.btnSelect.setOnClickListener {
            orderBottomSheet.show(
                requireActivity().supportFragmentManager,
                "OrderBottomSheet"
            )
        }
    }
}