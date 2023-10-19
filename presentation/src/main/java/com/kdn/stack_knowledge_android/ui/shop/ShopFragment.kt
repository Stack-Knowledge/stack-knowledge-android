package com.kdn.stack_knowledge_android.ui.shop

import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.kdn.domain.entity.item.ItemEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.shop.ItemListAdapter
import com.kdn.stack_knowledge_android.adapter.shop.OrderDetailListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.shop.BuyViewModel
import com.kdn.stack_knowledge_android.viewmodel.shop.ItemListVewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop) {
    private lateinit var orderBottomSheet: OrderBottomSheet
    private lateinit var itemListAdapter: ItemListAdapter
    private val buyViewModel by activityViewModels<BuyViewModel>()
    private val itemListViewModel by viewModels<ItemListVewModel>()
    private var selectedItemList = mutableListOf<ItemEntity>()

    override fun createView() {
        initRecyclerView()
        initBottomSheet()
    }

    override fun observeEvent() {
        repeatOnStart {
            itemListViewModel.eventFlow.collect { event -> observeItemData(event) }
        }
    }

    private fun initRecyclerView() {
        itemListViewModel.getItemList()
        itemListAdapter = ItemListAdapter { isChecked, itemEntity ->
            if (isChecked) {
                selectedItemList.add(itemEntity)
            } else if (!isChecked){
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