package com.kdn.domain.usecase.shop

import com.kdn.domain.param.order.OrderParam
import com.kdn.domain.repository.order.OrderRepository
import javax.inject.Inject

class BuyItemUseCase @Inject constructor(
    private val orderRepository: OrderRepository,
){
    suspend operator fun invoke(buyItemParam: List<OrderParam>) = kotlin.runCatching {
        orderRepository.buyItem(buyItemParam)
    }
}