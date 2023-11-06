package com.kdn.stack_knowledge_android.ui.shop

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.DialogItemDeductionBinding
import com.kdn.stack_knowledge_android.viewmodel.shop.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class ItemDeductionDialog(
    private val itemId: UUID,
) : DialogFragment() {
    private lateinit var binding: DialogItemDeductionBinding
    private val orderViewModel by activityViewModels<OrderViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DialogItemDeductionBinding.inflate(layoutInflater)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        binding.btnCheck.setOnClickListener {
            orderViewModel.updateOrderedItem(itemId)
            dialog?.dismiss()
            binding.btnCheck.setBackgroundColor(resources.getColor(R.color.main))
            orderViewModel.getOrderedItemList()
        }

        binding.btnCancel.setOnClickListener {
            binding.btnCancel.setBackgroundColor(resources.getColor(R.color.main))
            dialog?.dismiss()
        }

        return binding.root
    }
}