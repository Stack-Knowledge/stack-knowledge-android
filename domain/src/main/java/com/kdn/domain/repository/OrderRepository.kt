package com.kdn.domain.repository

import com.kdn.domain.param.BuyGoodsParam

interface OrderRepository {
    suspend fun buyGoods(buyGoodsParam: BuyGoodsParam)
}