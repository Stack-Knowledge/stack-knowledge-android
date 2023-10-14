package com.kdn.stack_knowledge_android.viewmodel.mission

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.entity.MissionEntity
import com.kdn.domain.usecase.mission.GetMissionListUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEvetFlow
import com.kdn.stack_knowledge_android.viewmodel.shop.ItemListVewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MissionViewModel @Inject constructor(
    private val getMissionListUseCase: GetMissionListUseCase,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEvetFlow()

    fun getMissionList() = viewModelScope.launch {
        getMissionListUseCase().onSuccess {
            event(Event.Mission(it))
        }.onFailure {
            Log.e("미션 가져오기 실패", "실패 $it")
        }
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class Mission(val missionList: List<MissionEntity>) : Event()
    }
}