package com.kdn.stack_knowledge_android.ui.shop

import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.kdn.domain.entity.ItemEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.shop.ItemListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.ui.main.MainActivity
import com.kdn.stack_knowledge_android.utils.ItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.shop.ItemListVewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop) {
    private lateinit var orderBottomSheet: OrderBottomSheet
    private lateinit var itemListAdapter: ItemListAdapter
    private lateinit var supportFragmentManager: FragmentManager
    private lateinit var mainActivity: MainActivity
    private val itemListViewModel by viewModels<ItemListVewModel>()
    private var selectedGoodsList: MutableList<ItemEntity> = mutableListOf()

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
        itemListViewModel.getGoodsList()
        itemListAdapter = ItemListAdapter { isChecked, itemEntity ->
            if (isChecked) {
                selectedGoodsList.add(itemEntity)
            } else {
                selectedGoodsList.remove(itemEntity)
            }
            binding.btnSelect.isVisible = selectedGoodsList.isNotEmpty()
        }
        binding.rvGoods.adapter = itemListAdapter
        binding.rvGoods.addItemDecoration(ItemDecorator(16))

    }

    private fun observeItemData(event: ItemListVewModel.Event) = when (event) {
        is ItemListVewModel.Event.Item -> {
            itemListAdapter.submitList(event.itemList)
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