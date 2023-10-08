package com.kdn.stack_knowledge_android.viewmodel.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.param.OrderParam
import com.kdn.domain.usecase.shop.BuyItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuyViewModel @Inject constructor(
    private val buyItemUseCase: BuyItemUseCase,
) : ViewModel() {
    var orderMap = mapOf<ItemEntity, Int>()
    fun buyItem() = viewModelScope.launch {
        val order = mutableListOf<OrderParam>()
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
}