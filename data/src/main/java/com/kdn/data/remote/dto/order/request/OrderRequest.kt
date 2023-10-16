package com.kdn.data.remote.dto.order.request

import com.google.gson.annotations.SerializedName
import com.kdn.domain.param.order.OrderParam
import java.util.UUID

data class OrderRequest(
    @SerializedName("itemId")
    val itemId: UUID,
    @SerializedName("count")
    val count: Int,
)

fun OrderParam.toRequest() = OrderRequest(
    itemId = itemId,
    count = count,
)
