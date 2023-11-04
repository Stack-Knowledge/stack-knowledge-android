package com.kdn.stack_knowledge_android.ui.mission

import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.FragmentCreateMissionBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateMissionFragment :
    BaseFragment<FragmentCreateMissionBinding>(R.layout.fragment_create_mission) {
    private lateinit var createMissionDialog: CreateMissionDialog

    override fun createView() {
        createMission()
    }

    override fun observeEvent() {
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