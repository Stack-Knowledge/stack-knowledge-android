package com.kdn.stack_knowledge_android.ui.mission

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kdn.domain.entity.mission.DetailMissionEntity
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.data.mission.DetailMissionData
import com.kdn.stack_knowledge_android.databinding.FragmentMissionBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.Event
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import com.kdn.stack_knowledge_android.viewmodel.solve.SolveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MissionFragment : BaseFragment<FragmentMissionBinding>(R.layout.fragment_mission) {
    private val solveViewModel by viewModels<SolveViewModel>()
    private val missionViewModel by activityViewModels<MissionViewModel>()
    private var missionDetailList = mutableListOf<DetailMissionData>()
    override fun createView() {
        setMission()
    }

    override fun observeEvent() {
        repeatOnStart {
            solveViewModel.eventFlow.collect { event -> observeSolveData(event) }
        }
    }

    private fun setMission() {
        val args: MissionFragmentArgs by navArgs()
        val title = args.title
        binding.tvMissionTitle.text = title
    }

    private fun observeSolveData(event: SolveViewModel.Event) = when (event) {
        is SolveViewModel.Event.SolveMission -> {
            requireActivity().findNavController(R.id.missionFragment)
                .navigate(R.id.action_missionFragment_to_missionFragment)
        }
    }
}