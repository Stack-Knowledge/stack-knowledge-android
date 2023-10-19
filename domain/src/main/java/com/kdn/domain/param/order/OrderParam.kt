package com.kdn.domain.param.order

import java.util.UUID

data class OrderParam (
    val itemId: UUID,
    val count: Int,
)