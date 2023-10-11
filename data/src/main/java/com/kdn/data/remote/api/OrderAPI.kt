package com.kdn.data.remote.api

import com.kdn.data.remote.dto.order.request.OrderRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderAPI {
    @POST("/order")
    suspend fun buyItem(
        @Body orderRequest: List<OrderRequest>,
    )

}