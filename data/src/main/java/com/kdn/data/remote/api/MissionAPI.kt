package com.kdn.data.remote.api

import com.kdn.data.remote.dto.mission.request.CreateMissionRequest
import com.kdn.data.remote.dto.mission.response.DetailMissionResponse
import com.kdn.data.remote.dto.mission.response.MissionResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface MissionAPI {
    @GET("/mission")
    suspend fun getMission(): List<MissionResponse>

    @GET("/mission/{missionId}")
    suspend fun getDetailMission(
        @Path("missionId") missionId: UUID,
    ): DetailMissionResponse

    @POST("/mission")
    suspend fun createMission(
        @Body body: CreateMissionRequest,
    )
}