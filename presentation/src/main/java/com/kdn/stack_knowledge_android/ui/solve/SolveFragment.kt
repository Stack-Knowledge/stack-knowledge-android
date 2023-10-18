package com.kdn.stack_knowledge_android.ui.solve

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.data.mission.DetailMissionData
import com.kdn.stack_knowledge_android.databinding.FragmentSolveBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import com.kdn.stack_knowledge_android.viewmodel.solve.SolveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SolveFragment : BaseFragment<FragmentSolveBinding>(R.layout.fragment_solve) {
    private val solveViewModel by viewModels<SolveViewModel>()
    private val missionViewModel by activityViewModels<MissionViewModel>()
    override fun createView() {
        setMission()
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
    }

    private fun observeSolveData(event: SolveViewModel.Event) = when (event) {
        is SolveViewModel.Event.SolveMission -> {
            requireActivity().findNavController(R.id.solveFragment)
                .navigate(R.id.action_solveFragment_self)
        }
    }
}