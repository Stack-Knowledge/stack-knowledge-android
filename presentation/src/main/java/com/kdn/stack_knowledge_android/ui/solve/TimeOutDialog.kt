package com.kdn.stack_knowledge_android.ui.solve

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kdn.stack_knowledge_android.databinding.DialogTimeOutBinding
import com.kdn.stack_knowledge_android.viewmodel.solve.SolveViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import java.util.UUID
import kotlin.concurrent.timer

@AndroidEntryPoint
class TimeOutDialog(
    private val missionId: UUID,
    private val answer: String,
) : DialogFragment(){
    private val closeTime = 3
    private var second = closeTime % 60
    private lateinit var binding: DialogTimeOutBinding
    private lateinit var timer: Timer
    private val solveViewModel by activityViewModels<SolveViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogTimeOutBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        solveViewModel.solveMission(missionId = missionId, solvation = answer)
        setTimer()

        return binding.root
    }

    private fun setTimer() = binding.apply {
        second = closeTime % 60
        timer = timer(period = 1000, initialDelay = 1000) {
            requireActivity().runOnUiThread {
                if (second == 0) {
                    timer?.cancel()
                    findNavController().popBackStack()
                    dialog?.dismiss()
                }
                second--
            }
        }
    }
}