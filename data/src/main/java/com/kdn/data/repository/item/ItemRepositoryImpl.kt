package com.kdn.data.repository.item

import com.kdn.data.local.item.LocalItemDataSource
import com.kdn.data.remote.datasource.item.RemoteItemDataSource
import com.kdn.data.remote.dto.item.response.toEntity
import com.kdn.domain.entity.ItemEntity
import com.kdn.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteItemDataSource,
    private val localDataSource: LocalItemDataSource,
) : ItemRepository{
    override suspend fun getGoodsList(): List<ItemEntity> =
        remoteDataSource.getGoodsList().map {
            it.toEntity()
        }
}