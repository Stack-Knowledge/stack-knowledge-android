package com.kdn.data.remote.dto.order.response

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class OrderResponse(
    @SerializedName("id")
    val id: UUID,
    @SerializedName("count")
    val count: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("orderStatus")
    val orderStatus: OrderStatus,
) {
    data class Item(
        @SerializedName("id")
        val id: UUID,
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
        val profile: String,
    )
}

enum class OrderStatus {
    IS_ORDERED,
    COMPLETED,
}

