package com.kdn.domain.entity

import java.util.UUID

data class GoodsEntity(
    val itemId: UUID,
    val name: String,
    val price: Int,
    val image: String,
)
