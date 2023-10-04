package com.kdn.domain.param

import java.util.UUID

data class BuyGoodsParam (
    val itemId: UUID,
    val count: Int,
)