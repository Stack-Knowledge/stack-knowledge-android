package com.kdn.domain.model.response

import java.util.UUID

data class GoodsResponseModel(
    val itemId: UUID,
    val name: String,
    val price: Int,
    val image: String,
)
