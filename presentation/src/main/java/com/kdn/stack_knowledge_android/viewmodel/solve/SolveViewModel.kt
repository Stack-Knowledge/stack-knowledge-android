package com.kdn.stack_knowledge_android.viewmodel.solve

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.param.solve.SolveParam
import com.kdn.domain.usecase.solve.SolveUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class SolveViewModel @Inject constructor(
    private val solveUseCase: SolveUseCase,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun solveMission(missionId: UUID, solvation: String) = viewModelScope.launch {
        val solveParam = SolveParam(
            solvation
        )
        solveUseCase(
            missionId = missionId,
            solveParam,
        ).onSuccess {
            event(Event.SolveMission(solveParam))
        }.onFailure {
            Log.e("문제 풀기 실패", "실패 $it")
        }
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class SolveMission(val solveMission: SolveParam) : Event()
    }
}