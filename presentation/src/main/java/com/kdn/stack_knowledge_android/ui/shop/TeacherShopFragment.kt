package com.kdn.stack_knowledge_android.ui.shop

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kdn.domain.entity.order.OrderedItemEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.shop.OrderedItemListAdapter
import com.kdn.stack_knowledge_android.databinding.DialogItemDeductionBinding
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
    private var orderedItemList = mutableListOf<OrderedItemEntity>()


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
                orderedItemList.add(item)
                orderViewModel.orderedItemList = orderedItemList
                val itemId: UUID = item.item.id
                val count: Int = item.count
                val action =
                    TeacherShopFragmentDirections.actionTeacherShopFragmentToItemDeductionDialog(
                        count,
                        itemId.toString()
                    )
                findNavController()
                    .navigate(action)
                initItemDeductionDialog()
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
    }

    private fun initItemDeductionDialog() {
        val args: TeacherShopFragmentArgs by navArgs()
        val itemId = args.orderId
        val parsedOrder = UUID.fromString(itemId)
        val count = args.count
        itemDeductionDialog = ItemDeductionDialog(itemId = parsedOrder, count)
        itemDeductionDialog.show(
            requireActivity().supportFragmentManager,
            "ItemDialogDeduction"
        )
    }
}