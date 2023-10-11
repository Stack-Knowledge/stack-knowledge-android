package com.kdn.domain.repository

import com.kdn.domain.entity.ItemEntity

interface ItemRepository {
    suspend fun getGoodsList(): List<ItemEntity>
}