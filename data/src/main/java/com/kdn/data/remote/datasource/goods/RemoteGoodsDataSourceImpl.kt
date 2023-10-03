package com.kdn.data.remote.datasource.goods

import com.kdn.data.remote.api.GoodsAPI
import com.kdn.data.remote.dto.goods.response.GoodsResponse
import com.kdn.data.remote.dto.goods.response.toEntity
import com.kdn.domain.entity.GoodsEntity
import javax.inject.Inject

class RemoteGoodsDataSourceImpl @Inject constructor(
    private val goodsAPI: GoodsAPI,
) : RemoteGoodsDataSource {
    override suspend fun getGoodsList(): List<GoodsResponse> =
        goodsAPI.getGoodsList()


}