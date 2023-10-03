package com.kdn.domain.repository

import com.kdn.domain.entity.GoodsEntity
import java.util.UUID

interface GoodsRepository {
    suspend fun getGoodsList(): List<GoodsEntity>
}