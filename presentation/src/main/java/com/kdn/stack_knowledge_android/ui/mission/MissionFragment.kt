package com.kdn.stack_knowledge_android.ui.mission

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.main.MissionListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentMissionBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.ui.main.MainFragmentDirections
import com.kdn.stack_knowledge_android.utils.VerticalItemDecorator
import com.kdn.stack_knowledge_android.utils.repeatOnStart
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel

class MissionFragment : BaseFragment<FragmentMissionBinding>(R.layout.fragment_mission) {
    private val missionViewModel by activityViewModels<MissionViewModel>()
    private lateinit var missionListAdapter: MissionListAdapter

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
        missionViewModel.getMissionList()
        missionListAdapter = MissionListAdapter().apply {
            setItemOnClickListener(object : MissionListAdapter.OnItemClickListener {
                override fun detail(item: MissionEntity?) {
                    item?.id?.let { missionViewModel.getDetailMission(it) }
                }
            })
        }
        binding.rvMission.adapter = missionListAdapter
        binding.rvMission.addItemDecoration(VerticalItemDecorator(16))
    }

    private fun observeMissionData(event: MissionViewModel.Event) = when (event) {
        is MissionViewModel.Event.Mission -> {
            missionListAdapter.submitList(event.missionList)
        }

        is MissionViewModel.Event.DetailMission -> {
            val title: String = event.detailMission.title
            val action =
                MissionFragmentDirections
                    .actionMissionFragmentToSolveFragment(title)
            findNavController()
                .navigate(action)
        }

        else -> {}
    }
}