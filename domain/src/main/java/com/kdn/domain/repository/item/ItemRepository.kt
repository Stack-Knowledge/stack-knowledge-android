package com.kdn.domain.repository.item

import com.kdn.domain.entity.ItemEntity

interface ItemRepository {
    suspend fun getItemList(): List<ItemEntity>
}