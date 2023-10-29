package com.kdn.stack_knowledge_android.ui.mission

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.adapter.score.SolvedMissionListAdapter
import com.kdn.stack_knowledge_android.databinding.FragmentScoringBinding
import com.kdn.stack_knowledge_android.ui.base.BaseFragment
import com.kdn.stack_knowledge_android.viewmodel.mission.MissionViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class ScoringFragment : BaseFragment<FragmentScoringBinding>(R.layout.fragment_scoring) {
    private val missionViewModel by activityViewModels<MissionViewModel>()
   override fun createView() {
       setSolvedMission()
       scoreSolvedMission()
    }

    override fun observeEvent() {
    }

    private fun scoreSolvedMission() {
        val args: ScoringFragmentArgs by navArgs()
        val solveId = args.solveId
        val parsedSolvedId = UUID.fromString(solveId)
        binding.rbtnCorrect.setOnClickListener {
            missionViewModel.scoreSolveMission(parsedSolvedId, "CORRECT_ANSWER")
        }
        binding.rbtnIncorrect.setOnClickListener {
            missionViewModel.scoreSolveMission(parsedSolvedId, "WRONG_ANSWER")
        }
    }

   private fun setSolvedMission() {
       val args: ScoringFragmentArgs by navArgs()
       val title = args.title
       val solvation = args.solvation
       binding.tvAnswer.text = solvation
       binding.tvTitle.text = title
   }
}