package com.kdn.stack_knowledge_android.viewmodel.ranking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.domain.usecase.student.GetMyInfoUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val getMyInfoUseCase: GetMyInfoUseCase,
) : ViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFLow = _eventFlow.asEventFlow()

    fun getMyInfo() = viewModelScope.launch {
        getMyInfoUseCase().onSuccess {
            event(Event.MyInfo(it))
        }.onFailure {
            Log.e("내정보 가져오기 실패", "실패 $it")
        }
    }
    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class MyInfo(val myInfo: List<MyInfoEntity>) : Event()
    }
}