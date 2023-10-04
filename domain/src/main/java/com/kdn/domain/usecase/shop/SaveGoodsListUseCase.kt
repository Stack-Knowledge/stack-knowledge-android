package com.kdn.domain.usecase.shop

import com.kdn.domain.repository.GoodsRepository
import com.kdn.domain.repository.OrderRepository
import javax.inject.Inject

class SaveGoodsListUseCase @Inject constructor(
    private val orderRepository: OrderRepository,
) {
    suspend operator fun invoke() = kotlin.runCatching {
        orderRepository.goodsOrderList()
    }
}