package com.kdn.stack_knowledge_android.ui.solve

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.main.MissionListAdapter
import com.kdn.stack_knowledge_android.databinding.DialogSubmitAnswerBinding
import com.kdn.stack_knowledge_android.viewmodel.solve.SolveViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class SubmitAnswerDialog(
    private val missionId: UUID,
    private val answer: String,
) : DialogFragment() {
    private lateinit var missionListAdapter: MissionListAdapter
    private lateinit var binding: DialogSubmitAnswerBinding
    private val solveViewModel by activityViewModels<SolveViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogSubmitAnswerBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        dialog?.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        binding.btnCheck.setOnClickListener {
            binding.btnCheck.setBackgroundColor(resources.getColor(R.color.main))
            solveViewModel.solveMission(missionId = missionId, solvation = answer)
            findNavController().popBackStack()
            dialog?.dismiss()
        }
        binding.btnCancel.setOnClickListener {
            binding.btnCancel.setBackgroundColor(resources.getColor(R.color.main))
            dialog?.dismiss()
        }

        return binding.root
    }

}