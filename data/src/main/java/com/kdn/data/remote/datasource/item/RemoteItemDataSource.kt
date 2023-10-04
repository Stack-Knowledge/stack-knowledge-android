package com.kdn.data.remote.datasource.item

import com.kdn.data.remote.dto.item.response.GoodsResponse

interface RemoteItemDataSource {
    suspend fun getGoodsList(): List<GoodsResponse>
}