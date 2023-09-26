package com.kdn.stack_knowledge_android.ui.shop

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.FragmentShopBinding
import com.kdn.stack_knowledge_android.ui.main.MainActivity

class OrderBottomSheet : BottomSheetDialogFragment() {
    private lateinit var mainActivity: MainActivity
    private val binding by lazy {FragmentShopBinding.inflate(layoutInflater)}

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainActivity = context as MainActivity

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun showBottomSheet() {
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_order, null)
        val bottomSheetDialog = BottomSheetDialog(mainActivity)
        bottomSheetDialog.setContentView(bottomSheetView)

        binding.btnSelect.setOnClickListener {
            bottomSheetDialog.show()
        }
    }
}