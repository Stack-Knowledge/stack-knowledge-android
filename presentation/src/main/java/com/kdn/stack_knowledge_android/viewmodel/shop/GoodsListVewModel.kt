package com.kdn.stack_knowledge_android.viewmodel.shop

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.GoodsEntity
import com.kdn.domain.usecase.shop.GetGoodsListUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEvetFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoodsListVewModel @Inject constructor(
    private val getGoodsListUseCase: GetGoodsListUseCase,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEvetFlow()

    fun getGoodsList() = viewModelScope.launch {
        getGoodsListUseCase().onSuccess {
            event(Event.Goods(it))
        }.onFailure {
             Log.e("아이템 가져오기 실패", "실패 $it")
        }
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class Goods(val goodsList: List<GoodsEntity>) : Event()
    }
}