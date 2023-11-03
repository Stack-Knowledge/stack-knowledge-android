package com.kdn.stack_knowledge_android.ui.mission

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.kdn.domain.param.user.ScoreParam
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.FragmentScoringBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class ScoringFragment : BaseFragment<FragmentScoringBinding>(R.layout.fragment_scoring) {
    private lateinit var finishGradingDialog: FinishGradingDialog
    private val missionViewModel by activityViewModels<MissionViewModel>()
    private var scoreStatusList = mutableListOf<ScoreParam>()
    override fun createView() {
        setSolvedMission()
        scoreSolvedMission()
    }

    override fun observeEvent() {
    }

    private fun scoreSolvedMission() {
        binding.btnSubmit.setOnClickListener {
            initFinishGradingDialog()
        }
    }

    private fun initFinishGradingDialog() {
        val args: ScoringFragmentArgs by navArgs()
        val solveId = args.solveId
        val parsedSolvedId = UUID.fromString(solveId)
        if (binding.rbtnCorrect.isChecked) {
            finishGradingDialog = FinishGradingDialog(parsedSolvedId, "CORRECT_ANSWER")
        }
        if (binding.rbtnIncorrect.isChecked) {
            finishGradingDialog = FinishGradingDialog(parsedSolvedId, "WRONG_ANSWER")
        }
        finishGradingDialog.show(
            requireActivity().supportFragmentManager,
            "FinishGradingDialog"
        )
    }

    private fun setSolvedMission() {
        val args: ScoringFragmentArgs by navArgs()
        val title = args.title
        val solvation = args.solvation
        binding.tvAnswer.text = solvation
        binding.tvTitle.text = title
    }
}