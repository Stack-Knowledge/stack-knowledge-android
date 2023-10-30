package com.kdn.stack_knowledge_android.ui.mission

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.FragmentCreateMissionBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateMissionFragment : BaseFragment<FragmentCreateMissionBinding>(R.layout.fragment_create_mission) {
    private lateinit var createMissionDialog: CreateMissionDialog
    private val missionViewModel by activityViewModels<MissionViewModel>()

    override fun createView() {
        createMission()
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }

    private fun createMission() {
        binding.btnSubmit.setOnClickListener {
            initCreateMissionDialog()
        }
    }

    private fun initCreateMissionDialog() {
        val title = binding.etInputTitle.text.toString()
        val content = binding.etInputContent.text.toString()
        val minute = binding.etMinute.text.toString()
        val second = binding.etSecond.text.toString()
        val timeLimit = minute + second
        createMissionDialog = CreateMissionDialog(title, content, timeLimit.toInt())
        createMissionDialog.show(
            requireActivity().supportFragmentManager,
            "CreateMissionDialog"
        )
    }
}