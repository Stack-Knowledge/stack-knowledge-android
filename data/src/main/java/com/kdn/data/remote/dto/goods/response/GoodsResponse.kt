package com.kdn.data.remote.dto.goods.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.GoodsEntity
import java.util.UUID

data class GoodsResponse(
    @SerializedName("itemId")
    val itemId: UUID,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("image")
    val image: String,
)

fun GoodsResponse.toEntity() = GoodsEntity(
    itemId = itemId,
    name = name,
    price= price,
    image = image,
)
