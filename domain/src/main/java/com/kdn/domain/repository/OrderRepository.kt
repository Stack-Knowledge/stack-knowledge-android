package com.kdn.domain.repository

import com.kdn.domain.entity.GoodsEntity
import com.kdn.domain.param.BuyGoodsParam

interface OrderRepository {
    suspend fun buyGoods(buyGoodsParam: BuyGoodsParam)
    suspend fun goodsOrderList(): List<GoodsEntity>
}