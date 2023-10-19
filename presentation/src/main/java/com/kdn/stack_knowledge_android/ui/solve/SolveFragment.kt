package com.kdn.stack_knowledge_android.ui.solve

import android.content.Context
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.FragmentSolveBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.ui.base.BottomNavigationViewVisibilityListener
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.solve.SolveViewModel
import java.util.Timer
import kotlin.concurrent.timer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SolveFragment : BaseFragment<FragmentSolveBinding>(R.layout.fragment_solve) {
    private val solveViewModel by viewModels<SolveViewModel>()
    private lateinit var bottomNavigationViewVisibilityListener: BottomNavigationViewVisibilityListener
    private lateinit var timer: Timer

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BottomNavigationViewVisibilityListener) {
            bottomNavigationViewVisibilityListener = context
        } else {
            throw RuntimeException("$context must implement BottomNavigationViewVisibilityListener")
        }
    }

    override fun createView() {
        setMission()
        bottomNavigationViewVisibilityListener.setBottomNavigationViewVisibility(false)
    }

    override fun onPause() {
        super.onPause()
        bottomNavigationViewVisibilityListener.setBottomNavigationViewVisibility(true)
        timer?.cancel()
    }

    override fun observeEvent() {
        repeatOnStart {
            solveViewModel.eventFlow.collect { event -> observeSolveData(event) }
        }
    }

    private fun setMission() {
        val args: SolveFragmentArgs by navArgs()
        val title = args.title
        binding.tvMissionTitle.text = title
        setTimer()
    }

    private fun setTimer() = binding.apply {
        val args: SolveFragmentArgs by navArgs()
        var timeLimit = args.timeLimit
        var minute = timeLimit / 60
        var second = timeLimit % 60
        tvTime.text = String.format("0$minute : %02d", second)
        timer = timer(period = 1000, initialDelay = 1000) {
            requireActivity().runOnUiThread {
                tvTime.text = String.format("0$minute : %02d", second)
            }
            if (minute == 0 && second == 0) {
                cancel()
                requireActivity().runOnUiThread {
                    tvTime.text = "00 : 00"
                }
                return@timer
            }
            if (second == 0) {
                minute--
                second = 60
            }
            second--
        }
    }

    private fun observeSolveData(event: SolveViewModel.Event) = when (event) {
        is SolveViewModel.Event.SolveMission -> {
            requireActivity().findNavController(R.id.solveFragment)
                .navigate(R.id.action_solveFragment_self)
        }
        else -> {}
    }
}