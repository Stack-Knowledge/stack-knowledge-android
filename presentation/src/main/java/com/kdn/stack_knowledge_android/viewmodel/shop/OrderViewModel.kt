package com.kdn.stack_knowledge_android.viewmodel.shop

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.order.OrderedItemEntity
import com.kdn.domain.param.order.UpdateOrderedParam
import com.kdn.domain.usecase.shop.GetOrderedItemListUseCase
import com.kdn.domain.usecase.shop.UpdateOrderedItemUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val getOrderedItemListUseCase: GetOrderedItemListUseCase,
    private val updateOrderedItemUseCase: UpdateOrderedItemUseCase,
) : ViewModel() {
    var orderedItemList: List<OrderedItemEntity> = mutableListOf()


    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()


    fun getOrderedItemList() = viewModelScope.launch {
        getOrderedItemListUseCase().onSuccess {
            event(Event.OrderedItem(it))
        }.onFailure {
            Log.e("주문된 아이템 가져오기 실패", "실패 $it")
        }
    }

    fun updateOrderedItem() = viewModelScope.launch {
        val orderId = orderedItemList.sumOf { it.id.hashCode() }
        val totalCount = orderedItemList.sumOf { it.count }
        val orderIdAsUUID = UUID.fromString(orderId.toString())
        val updateOrderedParam = UpdateOrderedParam(orderIdAsUUID, totalCount)
        updateOrderedItemUseCase(updateOrderedParam)
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class OrderedItem(val orderedItemList: List<OrderedItemEntity>) : Event()
    }
}