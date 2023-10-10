package com.kdn.stack_knowledge_android.viewmodel.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.param.OrderParam
import com.kdn.domain.usecase.shop.BuyItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class BuyViewModel(
    private val buyItemUseCase: BuyItemUseCase,
) : ViewModel() {


    private val _selectedItems = MutableLiveData<List<ItemEntity>>()
    val selectedItems: LiveData<List<ItemEntity>> get() = _selectedItems

    private var orderMap = mapOf<ItemEntity, Int>()
    val order = mutableListOf<OrderParam>()

    fun buyItem() = viewModelScope.launch {
        val checkedItems = selectedItems.value ?: emptyList()

        checkedItems.forEach { itemEntity ->
            order.add(OrderParam(itemId = itemEntity.itemId, count = orderMap[itemEntity] ?: 0))
        }

        orderMap.forEach { (itemEntity, count) ->
            order.plus(
                OrderParam(
                    itemId = itemEntity.itemId,
                    count = count
                )
            )
        }

        buyItemUseCase(order)
    }

    fun updateSelectedItems(items: List<ItemEntity>) {
        _selectedItems.value = items
    }
}