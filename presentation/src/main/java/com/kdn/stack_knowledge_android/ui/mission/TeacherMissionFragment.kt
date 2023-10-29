package com.kdn.stack_knowledge_android.ui.mission

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kdn.domain.entity.user.GetSolveMissionEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.score.SolvedMissionListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentTeacherMissionBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.utils.decorator.HorizontalItemDecorator
import com.kdn.stack_knowledge_android.utils.decorator.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class TeacherMissionFragment : BaseFragment<FragmentTeacherMissionBinding>(R.layout.fragment_teacher_mission) {
    private val missionViewModel by activityViewModels<MissionViewModel>()
    private lateinit var solvedMissionListAdapter: SolvedMissionListAdapter


    override fun createView() {
        initRecyclerView()
        observeEvent()
    }

    override fun observeEvent() {
        repeatOnStart {
            missionViewModel.eventFlow.collect { event -> observeMissionData(event)}
        }
    }

    private fun initRecyclerView() {
        missionViewModel.getSolvedMissionList()
        solvedMissionListAdapter = SolvedMissionListAdapter().apply {
            setItemOnClickListener(object : SolvedMissionListAdapter.OnItemClickListener {
                override fun detail(item: GetSolveMissionEntity) {
                    item.solveId.let { missionViewModel.getDetailSolvedMission(it) }
                }
            })
        }
        binding.rvSolvedMission.adapter = solvedMissionListAdapter
        binding.rvSolvedMission.addItemDecoration(HorizontalItemDecorator(16))
        binding.rvSolvedMission.addItemDecoration(VerticalItemDecorator(16))
    }

    private fun observeMissionData(event: MissionViewModel.Event) = when (event){
        is MissionViewModel.Event.SolvedMission -> {
            solvedMissionListAdapter.submitList(event.solvedMissionList)
        }

        is MissionViewModel.Event.DetailSolvedMission -> {
            val solveId: UUID = event.detailSolvedMission.solveId
            val solvation: String = event.detailSolvedMission.solvation
            val title: String = event.detailSolvedMission.title
            val action =
                TeacherMissionFragmentDirections
                    .actionTeacherMissionFragmentToScoringFragment(solveId.toString(), title, solvation)
            findNavController()
                .navigate(action)
        }
        else -> {}
    }
}