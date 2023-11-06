package com.kdn.stack_knowledge_android.ui.shop

import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.kdn.domain.entity.item.ItemEntity
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.shop.ItemListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.decorator.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.ranking.MyInfoViewModel
import com.kdn.stack_knowledge_android.viewmodel.shop.BuyViewModel
import com.kdn.stack_knowledge_android.viewmodel.shop.ItemListVewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop) {
    private lateinit var orderBottomSheet: OrderBottomSheet
    private lateinit var itemListAdapter: ItemListAdapter
    private val buyViewModel by activityViewModels<BuyViewModel>()
    private val itemListViewModel by viewModels<ItemListVewModel>()
    private val myInfoViewModel by activityViewModels<MyInfoViewModel>()
    private var selectedItemList = mutableListOf<ItemEntity>()

    override fun createView() {
        myInfoViewModel.getMyInfo()
        initRecyclerView()
        initBottomSheet()
        observeEvent()
    }

    override fun observeEvent() {
        repeatOnStart {
            itemListViewModel.eventFlow.collect { event -> observeItemData(event) }
        }
        repeatOnStart {
            myInfoViewModel.eventFlow.collect { event -> observeUserData(event) }
        }
    }

    private fun initRecyclerView() {
        itemListViewModel.getItemList()
        itemListAdapter = ItemListAdapter { isChecked, itemEntity ->
            if (isChecked) {
                selectedItemList.add(itemEntity)
            } else if (!isChecked) {
                selectedItemList.remove(itemEntity)
            }
            binding.btnSelect.isVisible = selectedItemList.isNotEmpty()
        }
        binding.rvGoods.adapter = itemListAdapter
        binding.rvGoods.addItemDecoration(VerticalItemDecorator(16))
    }

    private fun observeItemData(event: ItemListVewModel.Event) = when (event) {
        is ItemListVewModel.Event.Item -> {
            itemListAdapter.submitList(event.itemList)
        }

        else -> {}
    }

    private fun observeUserData(event: MyInfoViewModel.Event) = when (event) {
        is MyInfoViewModel.Event.MyInfo -> {
            binding.tvMileage.text = event.myInfo.currentPoint.toString()
        }

        else -> {}
    }
    private fun initBottomSheet() {
        orderBottomSheet = OrderBottomSheet()
        binding.btnSelect.setOnClickListener {
            buyViewModel.setOrderDataList(selectedItemList)
            orderBottomSheet.show(
                requireActivity().supportFragmentManager,
                "OrderBottomSheet"
            )
        }
    }
}