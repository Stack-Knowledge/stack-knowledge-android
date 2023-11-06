package com.kdn.data.remote.api.order

import com.kdn.data.remote.dto.order.request.OrderRequest
import com.kdn.data.remote.dto.order.request.UpdateOrderedRequest
import com.kdn.data.remote.dto.order.response.OrderedItemResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface OrderAPI {
    @POST("/order")
    suspend fun buyItem(
        @Body orderRequest: List<OrderRequest>,
    )

    @GET("/order")
    suspend fun getOrderedItem(): List<OrderedItemResponse>

    @PATCH("/order")
    suspend fun updateOrderedItem(
        @Body updateOrderedRequest: List<UpdateOrderedRequest>,
    )
}