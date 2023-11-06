package com.kdn.domain.usecase.shop

import com.kdn.domain.repository.order.OrderRepository
import javax.inject.Inject

class GetOrderedItemListUseCase @Inject constructor(
    private val orderRepository: OrderRepository,
) {
    suspend operator fun invoke() = kotlin.runCatching {
        orderRepository.getOrderedItem()
    }
}