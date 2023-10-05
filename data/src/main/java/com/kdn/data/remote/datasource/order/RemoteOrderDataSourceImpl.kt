package com.kdn.data.remote.datasource.order

import com.kdn.data.remote.api.OrderAPI
import com.kdn.data.remote.dto.order.request.OrderRequest
import com.kdn.data.utils.StackApiHandler
import javax.inject.Inject

class RemoteOrderDataSourceImpl @Inject constructor(
    private val service: OrderAPI,
) : RemoteOrderDataSource {
    override suspend fun buyItem(orderRequest: List<OrderRequest>) {
        return StackApiHandler<Unit>()
            .httpRequest { service.buyItem(orderRequest = orderRequest) }
            .sendRequest()
    }
}