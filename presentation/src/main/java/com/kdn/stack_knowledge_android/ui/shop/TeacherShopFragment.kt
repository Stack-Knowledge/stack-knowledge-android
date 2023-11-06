package com.kdn.stack_knowledge_android.ui.shop

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kdn.domain.entity.order.OrderedItemEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.shop.OrderedItemListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentTeacherShopBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.decorator.HorizontalItemDecorator
import com.kdn.stack_knowledge_android.utils.decorator.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.shop.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class TeacherShopFragment :
    BaseFragment<FragmentTeacherShopBinding>(R.layout.fragment_teacher_shop) {
    private lateinit var itemDeductionDialog: ItemDeductionDialog
    private lateinit var orderedItemListAdapter: OrderedItemListAdapter
    private val orderViewModel by activityViewModels<OrderViewModel>()


    override fun createView() {
        initRecyclerView()
        observeEvent()
    }

    override fun observeEvent() {
        repeatOnStart {
            orderViewModel.eventFlow.collect { event -> observeOrderedItemData(event) }
        }
    }

    private fun initRecyclerView() {
        orderViewModel.getOrderedItemList()
        orderedItemListAdapter = OrderedItemListAdapter()
        orderedItemListAdapter.setOnItemClickListener(object :
            OrderedItemListAdapter.OnItemClickListener {
            override fun onItemClick(item: OrderedItemEntity) {
                orderViewModel.orderedItem = item
                val itemId: UUID = item.id
                initItemDeductionDialog(itemId)
            }
        })
        binding.rvOrderedItem.adapter = orderedItemListAdapter
        binding.rvOrderedItem.addItemDecoration(HorizontalItemDecorator(15))
        binding.rvOrderedItem.addItemDecoration(VerticalItemDecorator(8))
    }

    private fun observeOrderedItemData(event: OrderViewModel.Event) = when (event) {
        is OrderViewModel.Event.OrderedItem -> {
            orderedItemListAdapter.submitList(event.orderedItemList)
        }
        else -> {}
    }

    private fun initItemDeductionDialog(itemId: UUID) {
        itemDeductionDialog = ItemDeductionDialog(itemId)
        itemDeductionDialog.show(
            requireActivity().supportFragmentManager,
            "ItemDialogDeduction"
        )
    }
}