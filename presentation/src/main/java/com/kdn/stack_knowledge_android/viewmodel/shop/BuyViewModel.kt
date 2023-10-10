package com.kdn.stack_knowledge_android.viewmodel.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.param.OrderParam
import com.kdn.domain.usecase.shop.BuyItemUseCase
import com.kdn.stack_knowledge_android.data.order.DetailOrderData
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

    val orderDataList: List<DetailOrderData>
        get() {
            val detailOrderList = mutableListOf<DetailOrderData>()

            orderMap.forEach { (itemEntity, count) ->
                val detailOrderData = DetailOrderData(
                    itemId = itemEntity.itemId,
                    name = itemEntity.name,
                    count = count,
                    price = itemEntity.price,
                )
                detailOrderList.add(detailOrderData)
            }

            return detailOrderList
        }

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

        val orderParams = convertToOrderParams(orderDataList)
        buyItemUseCase(orderParams)
    }

    private fun convertToOrderParams(detailsOrderList: List<DetailOrderData>): List<OrderParam> {
        val orderParams = mutableListOf<OrderParam>()

        detailsOrderList.forEach { detailOrderData ->
            val orderParam = OrderParam(
                itemId = detailOrderData.itemId,
                count = detailOrderData.count,
            )
            orderParams.add(orderParam)
        }

        return orderParams
    }

    fun updateSelectedItems(items: List<ItemEntity>) {
        _selectedItems.value = items
    }
}