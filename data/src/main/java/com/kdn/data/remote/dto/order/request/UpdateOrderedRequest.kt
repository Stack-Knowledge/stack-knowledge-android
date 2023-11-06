package com.kdn.data.remote.dto.order.request

import com.google.gson.annotations.SerializedName
import com.kdn.domain.param.order.UpdateOrderedParam
import java.util.UUID

data class UpdateOrderedRequest(
    @SerializedName("orderId")
    val orderId: UUID,
    @SerializedName("count")
    val count: Int = 1,
)

fun UpdateOrderedParam.toRequest() = UpdateOrderedRequest(
    orderId = orderId,
    count = count,
)