package com.kdn.data.remote.dto.item.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.item.ItemEntity
import java.util.UUID

data class ItemResponse(
    @SerializedName("itemId")
    val itemId: UUID,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("image")
    val image: String,
)

fun ItemResponse.toEntity() = ItemEntity(
    itemId = itemId,
    name = name,
    price= price,
    image = image,
)
