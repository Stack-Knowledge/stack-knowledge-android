package com.kdn.data.remote.api

import retrofit2.http.GET


interface GoodsAPI {

    @GET("/item")
    suspend fun allGoods(

    )
}