package com.kdn.data.remote.dto.order.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.order.OrderedItemEntity
import java.util.UUID

data class OrderedItemResponse(
    @SerializedName("id")
    val id: UUID,
    @SerializedName("count")
    val count: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("user")
    val user: User,
    @SerializedName("item")
    val item: Item,

    ) {
    data class Item(
        @SerializedName("itemId")
        val itemId: UUID,
        @SerializedName("name")
        val name: String,
        @SerializedName("price")
        val price: Int,
        @SerializedName("image")
        val image: String,

    )
    data class User(
        @SerializedName("id")
        val id: UUID,
        @SerializedName("email")
        val email: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("profileImage")
        val profileImage: String,
    )
}

fun OrderedItemResponse.toEntity() = OrderedItemEntity(
    id = id,
    count = count,
    price = price,
    item = OrderedItemEntity.Item(
        id = item.itemId,
        name = item.name,
        price = item.price,
        image = item.image,
    ),
    user = OrderedItemEntity.User(
        id = user.id,
        email = user.email,
        name = user.name,
        profileImage = user.profileImage,
    ),
)