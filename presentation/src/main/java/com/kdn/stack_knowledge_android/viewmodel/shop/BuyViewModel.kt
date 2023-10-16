package com.kdn.stack_knowledge_android.viewmodel.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.param.order.OrderParam
import com.kdn.domain.usecase.shop.BuyItemUseCase
import com.kdn.stack_knowledge_android.data.order.DetailOrderData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuyViewModel @Inject constructor(
    private val buyItemUseCase: BuyItemUseCase,
) : ViewModel() {
    val orderDataList: MutableList<DetailOrderData> = mutableListOf()

    fun setOrderDataList(orderDataList: List<ItemEntity>) {
        this.orderDataList.clear()
        orderDataList.forEach { itemEntity ->
            val detailOrderData = DetailOrderData(
                itemId = itemEntity.itemId,
                name = itemEntity.name,
                count = 1,
                price = itemEntity.price,
            )
            this.orderDataList.add(detailOrderData)
        }
    }

    fun buyItem() = viewModelScope.launch {
        val orderParams = orderDataList.map {
            OrderParam(it.itemId, it.count)
        }
        buyItemUseCase(orderParams)
    }

    fun plusItem(item: DetailOrderData) {
        orderDataList.replaceAll {
            if (it.itemId == item.itemId) {
                it.copy(count = it.count + 1)
            } else {
                it
            }
        }
    }

    fun minusItem(item: DetailOrderData) {
        orderDataList.replaceAll {
            if (it.itemId == item.itemId) {
                it.copy(count = it.count - 1)
            } else {
                it
            }
        }
    }
}