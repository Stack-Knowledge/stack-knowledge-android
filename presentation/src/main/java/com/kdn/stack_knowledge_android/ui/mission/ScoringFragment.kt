package com.kdn.stack_knowledge_android.ui.mission

import androidx.fragment.app.activityViewModels
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.score.SolvedMissionListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentScoringBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel

class ScoringFragment : BaseFragment<FragmentScoringBinding>(R.layout.fragment_scoring) {
    private val missionViewModel by activityViewModels<MissionViewModel>()
    private lateinit var solvedMissionListAdapter: SolvedMissionListAdapter
    override fun createView() {
        initRecyclerView()
    }

    override fun observeEvent() {
    }

    private fun initRecyclerView() {

    }

    private fun observeMissionData(event: MissionViewModel.Event) = when (event){
        is MissionViewModel.Event.SolvedMission -> {
            solvedMissionListAdapter.submitList(event.solvedMissionList)
        }

        is MissionViewModel.Event.
        else -> {}
    }
}