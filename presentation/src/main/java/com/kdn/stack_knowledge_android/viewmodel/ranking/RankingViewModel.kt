package com.kdn.stack_knowledge_android.viewmodel.ranking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.student.RankingEntity
import com.kdn.domain.usecase.student.GetRankingListUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEvetFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getRankingListUseCase: GetRankingListUseCase,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEvetFlow()

    fun getRankingList() = viewModelScope.launch {
        getRankingListUseCase().onSuccess {
            event(Event.Ranking(it))
        }.onFailure {
            Log.e("랭킹 가져오기 실패", "실패 $it")
        }
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class Ranking(val rankingList: List<RankingEntity>) : Event()
    }
}