package com.kdn.stack_knowledge_android.ui.mission

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.kdn.stack_knowledge_android.databinding.DialogMovePageFromMissionBinding
import com.kdn.stack_knowledge_android.databinding.DialogSubmitAnswerBinding
import com.kdn.stack_knowledge_android.viewmodel.solve.SolveViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class MovePageDialog(
    private val missionId: UUID,
    private val answer: String,
) : DialogFragment() {
    private lateinit var binding: DialogMovePageFromMissionBinding
    private val solveViewModel by activityViewModels<SolveViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogMovePageFromMissionBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        binding.btnCheck.setOnClickListener {
            solveViewModel.solveMission(missionId = missionId, solvation = answer)
        }

        return binding.root
    }
}