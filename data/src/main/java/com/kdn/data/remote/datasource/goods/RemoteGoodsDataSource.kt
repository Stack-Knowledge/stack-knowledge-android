package com.kdn.data.remote.datasource.goods

import com.kdn.data.remote.dto.goods.response.GoodsResponse
import java.util.UUID

interface RemoteGoodsDataSource {
    suspend fun getGoodsList(): List<GoodsResponse>
}