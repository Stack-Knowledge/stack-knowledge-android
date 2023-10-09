package com.kdn.stack_knowledge_android.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kdn.stack_knowledge_android.adapter.shop.OrderDetailListAdapter
import com.kdn.stack_knowledge_android.databinding.BottomSheetOrderBinding
import com.kdn.stack_knowledge_android.ui.main.MainActivity
import com.kdn.stack_knowledge_android.viewmodel.shop.BuyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderBottomSheet : BottomSheetDialogFragment() {
    private lateinit var mainActivity: MainActivity
    private lateinit var binding: BottomSheetOrderBinding
    private lateinit var orderDetailListAdapter: OrderDetailListAdapter
    private val buyViewModel by activityViewModels<BuyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetOrderBinding.inflate(layoutInflater)
        mainActivity = context as MainActivity
        binding.lifecycleOwner = this
        binding.btnBuy.setOnClickListener {
            buyViewModel.buyItem()
        }

        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        orderDetailListAdapter.submitList(buyViewModel.order)
    }

}