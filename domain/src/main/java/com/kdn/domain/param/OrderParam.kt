package com.kdn.domain.param

import java.util.UUID

data class OrderParam (
    val itemId: UUID,
    val count: Int,
)