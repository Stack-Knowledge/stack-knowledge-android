package com.kdn.data.remote.api

import retrofit2.http.GET

interface MissionAPI {
    @GET("/mission")
    suspend fun getMission()
}