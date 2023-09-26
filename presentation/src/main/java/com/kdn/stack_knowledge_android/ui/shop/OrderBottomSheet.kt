package com.kdn.stack_knowledge_android.ui.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kdn.stack_knowledge_android.databinding.BottomSheetOrderBinding
import com.kdn.stack_knowledge_android.ui.main.MainActivity

class OrderBottomSheet : BottomSheetDialogFragment() {
    private lateinit var mainActivity: MainActivity
    private lateinit var binding: BottomSheetOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetOrderBinding.inflate(layoutInflater)
        mainActivity = context as MainActivity
        binding.lifecycleOwner = this


        return binding.root
    }

    private fun initRecyclerView() {

    }

}