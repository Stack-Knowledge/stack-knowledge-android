package com.kdn.stack_knowledge_android.ui.mission

import androidx.fragment.app.activityViewModels
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.FragmentCreateMissionBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateMissionFragment : BaseFragment<FragmentCreateMissionBinding>(R.layout.fragment_create_mission) {
    private val missionViewModel by activityViewModels<MissionViewModel>()

    override fun createView() {
        TODO("Not yet implemented")
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }
}