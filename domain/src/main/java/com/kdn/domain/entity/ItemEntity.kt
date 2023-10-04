package com.kdn.domain.entity

import java.util.UUID

data class ItemEntity(
    val itemId: UUID,
    val name: String,
    val price: Int,
    val image: String,
)
