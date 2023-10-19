package com.kdn.domain.entity.item

import java.util.UUID

data class ItemEntity(
    val itemId: UUID,
    val name: String,
    val price: Int,
    val image: String,
)
