package com.kdn.stack_knowledge_android.ui.shop

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kdn.stack_knowledge_android.data.order.DetailOrderData
import com.kdn.stack_knowledge_android.databinding.DialogBuyBinding
import com.kdn.stack_knowledge_android.viewmodel.shop.BuyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderDialog(
    private val orderDataList: MutableList<DetailOrderData> = mutableListOf()
) : DialogFragment() {
    private lateinit var binding: DialogBuyBinding
    private val buyViewModel by activityViewModels<BuyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogBuyBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        dialog?.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        binding.btnCheck.setOnClickListener {
            buyViewModel.buyItem()
            findNavController().popBackStack()
            dialog?.dismiss()
        }

        binding.btnCancel.setOnClickListener {
            orderDataList.clear()
            dialog?.dismiss()
        }

        return binding.root
    }
}