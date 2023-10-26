package com.kdn.stack_knowledge_android.viewmodel.shop

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.order.OrderedItemEntity
import com.kdn.domain.usecase.shop.GetOrderedItemListUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val getOrderedItemListUseCase: GetOrderedItemListUseCase,
) : ViewModel() {
    val orderedItemList: MutableList<OrderedItemEntity> = mutableListOf()


    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()


    fun getOrderedItemList() = viewModelScope.launch {
        getOrderedItemListUseCase().onSuccess {
            event(Event.OrderedItem(it))
        }.onFailure {
            Log.e("주문된 아이템 가져오기 실패", "실패 $it")
        }
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class OrderedItem(val orderedItemList: List<OrderedItemEntity>) : Event()
    }
}