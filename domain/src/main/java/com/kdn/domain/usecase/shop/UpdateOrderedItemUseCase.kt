package com.kdn.domain.usecase.shop

import com.kdn.domain.param.order.UpdateOrderedParam
import com.kdn.domain.repository.order.OrderRepository
import javax.inject.Inject

class UpdateOrderedItemUseCase @Inject constructor(
    private val orderRepository: OrderRepository,
) {
    suspend operator fun invoke(updateOrderedParam: UpdateOrderedParam) = kotlin.runCatching {
        orderRepository.updateOrderedItem(updateOrderedParam)
    }
}