package com.kdn.domain.repository.order

import com.kdn.domain.entity.order.OrderedItemEntity
import com.kdn.domain.param.order.OrderParam
import com.kdn.domain.param.order.UpdateOrderedParam

interface OrderRepository {
    suspend fun buyItem(orderParam: List<OrderParam>)
    suspend fun getOrderedItem(): List<OrderedItemEntity>
    suspend fun updateOrderedItem(updateOrderedParam: List<UpdateOrderedParam>)
}