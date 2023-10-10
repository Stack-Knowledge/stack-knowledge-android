package com.kdn.stack_knowledge_android.data.order

import java.util.UUID

data class DetailOrderData(
    val itemId: UUID,
    val name: String,
    val count: Int,
    val price: Int,
)