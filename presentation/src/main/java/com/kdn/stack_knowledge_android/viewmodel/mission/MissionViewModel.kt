package com.kdn.stack_knowledge_android.viewmodel.mission

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.mission.DetailMissionEntity
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.domain.param.mission.CreateMissionParam
import com.kdn.domain.param.user.ScoreParam
import com.kdn.domain.usecase.mission.CreateMissionUseCase
import com.kdn.domain.usecase.mission.GetDetailMissionUseCase
import com.kdn.domain.usecase.mission.GetMissionListUseCase
import com.kdn.domain.usecase.mission.ScoreSolveMissionUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MissionViewModel @Inject constructor(
    private val getMissionListUseCase: GetMissionListUseCase,
    private val getDetailMissionUseCase: GetDetailMissionUseCase,
    private val createMissionUseCase: CreateMissionUseCase,
    private val scoreSolveMissionUseCase: ScoreSolveMissionUseCase,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun getMissionList() = viewModelScope.launch {
        getMissionListUseCase().onSuccess {
            event(Event.Mission(it))
        }.onFailure {
            Log.e("미션 가져오기 실패", "실패 $it")
        }
    }

    fun getDetailMission(missionId: UUID) = viewModelScope.launch {
        getDetailMissionUseCase(
            missionId = missionId
        ).onSuccess {
            event(Event.DetailMission(it, missionId = missionId))
        }.onFailure {
            Log.e("미션 상세보기 가져오기 실패", "실패 $it")
        }
    }

    fun createMission(title: String, content: String, timeLimit: Int) = viewModelScope.launch {
        val createMissionParam = CreateMissionParam(
            title, content, timeLimit,
        )
        createMissionUseCase(createMissionParam).onSuccess {
            event(Event.CreateMission(createMissionParam))
        }.onFailure {
            Log.e("미션 생성 실패", "실패 $it")
        }
    }

    fun scoreSolveMission(solveId: UUID, solveStatus: String) = viewModelScope.launch {
        val scoreSolveMissionParam = ScoreParam(
            solveStatus
        )
        scoreSolveMissionUseCase(solveId, scoreSolveMissionParam).onSuccess {
            event(Event.ScoreSolveMission(scoreSolveMissionParam, solveId))
        }
    }


    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class Mission(val missionList: List<MissionEntity>) : Event()
        data class DetailMission(val detailMission: DetailMissionEntity, val missionId: UUID) : Event()
        data class CreateMission(val createMission: CreateMissionParam) : Event()
        data class ScoreSolveMission(val scoreSolveMission: ScoreParam, val solveId: UUID) : Event()
    }
}