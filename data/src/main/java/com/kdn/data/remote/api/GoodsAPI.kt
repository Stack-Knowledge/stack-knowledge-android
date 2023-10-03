package com.kdn.data.remote.api

import com.kdn.data.remote.dto.goods.response.GoodsResponse
import com.kdn.domain.entity.GoodsEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface GoodsAPI {

    @GET("/item")
    suspend fun getGoodsList(
    ): List<GoodsEntity>
}