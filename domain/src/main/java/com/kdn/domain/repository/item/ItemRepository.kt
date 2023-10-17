package com.kdn.domain.repository.item

import com.kdn.domain.entity.item.ItemEntity

interface ItemRepository {
    suspend fun getItemList(): List<ItemEntity>
}