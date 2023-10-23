package com.kdn.data.remote.datasource.item

import com.kdn.data.remote.api.item.ItemAPI
import com.kdn.data.remote.dto.item.response.ItemResponse
import com.kdn.data.utils.StackApiHandler
import javax.inject.Inject

class RemoteItemDataSourceImpl @Inject constructor(
    private val service: ItemAPI,
) : RemoteItemDataSource {
    override suspend fun getItemList(): List<ItemResponse> {
        return StackApiHandler<List<ItemResponse>>()
            .httpRequest { service.getItemList() }
            .sendRequest()
    }
}