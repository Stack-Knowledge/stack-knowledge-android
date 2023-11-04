package com.kdn.stack_knowledge_android.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kdn.stack_knowledge_android.adapter.shop.OrderDetailListAdapter
import com.kdn.stack_knowledge_android.data.order.DetailOrderData
import com.kdn.stack_knowledge_android.databinding.BottomSheetOrderBinding
import com.kdn.stack_knowledge_android.utils.decorator.VerticalItemDecorator
import com.kdn.stack_knowledge_android.viewmodel.shop.BuyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderBottomSheet : BottomSheetDialogFragment() {
    private lateinit var orderDialog: OrderDialog
    private lateinit var binding: BottomSheetOrderBinding
    private lateinit var orderDetailListAdapter: OrderDetailListAdapter
    private val buyViewModel by activityViewModels<BuyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = BottomSheetOrderBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.btnBuy.setOnClickListener {
            initOrderDialog()
        }
        setTotalPrice()
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        orderDetailListAdapter = OrderDetailListAdapter().apply {
            setItemOnClickListener(object : OrderDetailListAdapter.OnItemClickListener {
                override fun plus(item: DetailOrderData) {
                    buyViewModel.plusItem(item)
                    setTotalPrice()
                }

                override fun minus(item: DetailOrderData) {
                    buyViewModel.minusItem(item)
                    setTotalPrice()
                }
            })
        }
        binding.rvDetailOrder.adapter = orderDetailListAdapter
        orderDetailListAdapter.submitList(buyViewModel.orderDataList)
        binding.rvDetailOrder.addItemDecoration(VerticalItemDecorator(10))
    }

    private fun setTotalPrice() {
        binding.tvTotalPrice.text =
            buyViewModel.orderDataList.sumOf { it.count * it.price }.toString()
    }

    private fun initOrderDialog() {
        orderDialog = OrderDialog {
            this.dismiss()
        }
        orderDialog.show(
            requireActivity().supportFragmentManager,
            "OrderDialog"
        )
    }


}