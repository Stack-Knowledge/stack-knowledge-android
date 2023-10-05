package com.kdn.data.repository.order

import com.kdn.data.remote.datasource.order.RemoteOrderDataSource
import com.kdn.data.remote.dto.order.request.toRequest
import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.param.OrderParam
import com.kdn.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteOrderDataSource,
) : OrderRepository {
    override suspend fun buyItem(orderParam: List<OrderParam>) =
        remoteDataSource.buyItem(orderParam.map { it.toRequest() })
}