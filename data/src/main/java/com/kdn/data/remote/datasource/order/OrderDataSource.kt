package com.kdn.data.remote.datasource.order

import com.kdn.data.remote.dto.goods.response.GoodsResponse

interface OrderDataSource {
    suspend fun initOrderInfo(): GoodsResponse
    suspend fun createOrder():
}