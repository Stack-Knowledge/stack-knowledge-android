package com.kdn.data.remote.datasource.item

import com.kdn.data.remote.api.ItemAPI
import com.kdn.data.remote.dto.item.response.GoodsResponse
import com.kdn.data.utils.StackApiHandler
import javax.inject.Inject

class RemoteItemDataSourceImpl @Inject constructor(
    private val service: ItemAPI,
) : RemoteItemDataSource {
    override suspend fun getGoodsList(): List<GoodsResponse> {
        return StackApiHandler<List<GoodsResponse>>()
            .httpRequest { service.getGoodsList() }
            .sendRequest()

    }

}