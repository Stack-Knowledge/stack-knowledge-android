package com.kdn.data.remote.datasource.order

import com.kdn.data.remote.dto.order.request.OrderRequest
import com.kdn.data.remote.dto.order.request.UpdateOrderedRequest
import com.kdn.data.remote.dto.order.response.OrderedItemResponse

interface RemoteOrderDataSource {
    suspend fun buyItem(orderRequest: List<OrderRequest>)
    suspend fun getOrderedItem(): List<OrderedItemResponse>

    suspend fun updateOrderedItem(updateOrderedRequest: List<UpdateOrderedRequest>)
}