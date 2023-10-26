package com.kdn.domain.param.order

import java.util.UUID

data class UpdateOrderedParam (
    val orderId: UUID,
    val count: Int,
)