package com.kdn.domain.repository.order

import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.param.OrderParam

interface OrderRepository {
    suspend fun buyItem(orderParam: List<OrderParam>)
}