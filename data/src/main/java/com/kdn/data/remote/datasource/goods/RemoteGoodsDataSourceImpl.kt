package com.kdn.data.remote.datasource.goods

import com.kdn.data.remote.api.GoodsAPI
import com.kdn.data.remote.dto.goods.response.GoodsResponse
import com.kdn.data.utils.StackApiHandler
import com.kdn.domain.entity.GoodsEntity
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteGoodsDataSourceImpl @Inject constructor(
    private val service: GoodsAPI,
) : RemoteGoodsDataSource {
    override suspend fun getGoodsList(): List<GoodsResponse> {
        return StackApiHandler<List<GoodsResponse>>()
            .httpRequest { service.getGoodsList() }
            .sendRequest()

    }

}