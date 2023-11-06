package com.kdn.domain.entity.order

import java.util.UUID

data class OrderedItemEntity(
    val id: UUID,
    val count: Int,
    val price: Int,
    val user: User,
    val item: Item,

    ) {
    data class Item(
        val id: UUID,
        val name: String,
        val price: Int,
        val image: String,
        )

    data class User(
        val id: UUID,
        val email: String,
        val name: String,
        val profileImage: String,
    )
}