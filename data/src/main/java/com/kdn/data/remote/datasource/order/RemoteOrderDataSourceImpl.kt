package com.kdn.data.remote.datasource.order

import com.kdn.data.remote.api.order.OrderAPI
import com.kdn.data.remote.dto.order.request.OrderRequest
import com.kdn.data.remote.dto.order.request.UpdateOrderedRequest
import com.kdn.data.remote.dto.order.response.OrderedItemResponse
import com.kdn.data.utils.StackApiHandler
import java.util.Stack
import javax.inject.Inject

class RemoteOrderDataSourceImpl @Inject constructor(
    private val service: OrderAPI,
) : RemoteOrderDataSource {
    override suspend fun buyItem(orderRequest: List<OrderRequest>) {
        return StackApiHandler<Unit>()
            .httpRequest { service.buyItem(orderRequest = orderRequest) }
            .sendRequest()
    }

    override suspend fun getOrderedItem(): List<OrderedItemResponse> {
        return StackApiHandler<List<OrderedItemResponse>>()
            .httpRequest { service.getOrderedItem() }
            .sendRequest()
    }

    override suspend fun updateOrderedItem(updateOrderedRequest: UpdateOrderedRequest) {
        return StackApiHandler<Unit>()
            .httpRequest { service.updateOrderedItem(updateOrderedRequest = updateOrderedRequest) }
            .sendRequest()
    }
}