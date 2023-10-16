package com.kdn.domain.repository.order

import com.kdn.domain.param.order.OrderParam

interface OrderRepository {
    suspend fun buyItem(orderParam: List<OrderParam>)
}