package com.kdn.data.remote.datasource.order

import com.kdn.data.remote.dto.order.request.OrderRequest

interface RemoteOrderDataSource {
    suspend fun buyItem(orderRequest: List<OrderRequest>)
}