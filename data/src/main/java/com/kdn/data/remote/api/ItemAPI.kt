package com.kdn.data.remote.api

import com.kdn.data.remote.dto.item.response.GoodsResponse
import retrofit2.http.GET


interface ItemAPI {
    @GET("/item")
    suspend fun getGoodsList(): List<GoodsResponse>
}