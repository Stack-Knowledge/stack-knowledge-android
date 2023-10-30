package com.kdn.stack_knowledge_android.ui.mission

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
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.DialogSubmitQuestionBinding
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateMissionDialog(
    private val title: String,
    private val content: String,
    private val timeLimit: Int,
) : DialogFragment() {
    private val missionViewModel by activityViewModels<MissionViewModel>()
    private lateinit var binding: DialogSubmitQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DialogSubmitQuestionBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        binding.btnCheck.setOnClickListener {
            binding.btnCheck.setBackgroundColor(resources.getColor(R.color.main))
            missionViewModel.createMission(title = title, content = content, timeLimit = timeLimit)
            findNavController().popBackStack()
            dialog?.dismiss()
        }
        binding.btnCancel.setOnClickListener {
            binding.btnCancel.setBackgroundColor(resources.getColor(R.color.main))
            dialog?.dismiss()
        }

        return binding.root
    }
}