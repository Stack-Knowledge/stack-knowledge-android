package com.kdn.domain.usecase.shop

import com.kdn.domain.param.BuyGoodsParam
import com.kdn.domain.repository.OrderRepository
import javax.inject.Inject

class BuyItemUseCase @Inject constructor(
    private val orderRepository: OrderRepository,
){
    suspend operator fun invoke(buyGoodsParam: BuyGoodsParam) = kotlin.runCatching {
        orderRepository.buyGoods(buyGoodsParam)
    }
}