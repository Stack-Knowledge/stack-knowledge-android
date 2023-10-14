package com.kdn.data.remote.api

import com.kdn.data.remote.dto.mission.response.MissionResponse
import retrofit2.http.GET

interface MissionAPI {
    @GET("/mission")
    suspend fun getMission(): List<MissionResponse>
}