package com.kdn.data.repository.goods

import com.kdn.data.local.goods.LocalGoodsDataSource
import com.kdn.data.remote.datasource.goods.RemoteGoodsDataSource
import com.kdn.data.remote.dto.goods.response.toEntity
import com.kdn.domain.entity.GoodsEntity
import com.kdn.domain.repository.GoodsRepository
import javax.inject.Inject

class GoodsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteGoodsDataSource,
    private val localDataSource: LocalGoodsDataSource,
) : GoodsRepository{
    override suspend fun getGoodsList(): List<GoodsEntity> =
        remoteDataSource.getGoodsList().map {
            it.toEntity()
        }
}