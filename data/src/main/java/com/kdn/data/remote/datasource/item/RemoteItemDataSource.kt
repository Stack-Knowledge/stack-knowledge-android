package com.kdn.data.remote.datasource.item

import com.kdn.data.remote.dto.item.response.ItemResponse

interface RemoteItemDataSource {
    suspend fun getItemList(): List<ItemResponse>
}