package com.kdn.data.repository.item

import com.kdn.data.remote.datasource.item.RemoteItemDataSource
import com.kdn.data.remote.dto.item.response.toEntity
import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.repository.item.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteItemDataSource,
) : ItemRepository {
    override suspend fun getItemList(): List<ItemEntity> =
        remoteDataSource.getItemList().map {
            it.toEntity()
        }
}