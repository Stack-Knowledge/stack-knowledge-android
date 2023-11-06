package com.kdn.data.repository.order

import com.kdn.data.remote.datasource.order.RemoteOrderDataSource
import com.kdn.data.remote.dto.order.request.toRequest
import com.kdn.data.remote.dto.order.response.toEntity
import com.kdn.domain.entity.order.OrderedItemEntity
import com.kdn.domain.param.order.OrderParam
import com.kdn.domain.param.order.UpdateOrderedParam
import com.kdn.domain.repository.order.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteOrderDataSource,
) : OrderRepository {
    override suspend fun buyItem(orderParam: List<OrderParam>) =
        remoteDataSource.buyItem(orderParam.map { it.toRequest() })

    override suspend fun getOrderedItem(): List<OrderedItemEntity> =
        remoteDataSource.getOrderedItem().map { it.toEntity() }

    override suspend fun updateOrderedItem(updateOrderedParam: List<UpdateOrderedParam>) =
        remoteDataSource.updateOrderedItem(updateOrderedParam.map{it.toRequest() })
}