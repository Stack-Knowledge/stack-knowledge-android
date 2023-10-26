package com.kdn.data.remote.api.user

import com.kdn.data.remote.dto.user.request.ScoreRequest
import com.kdn.data.remote.dto.user.response.DetailSolveMissionResponse
import com.kdn.data.remote.dto.user.response.GetSolveMissionResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface UserAPI {
    @GET("/user/scoring")
    suspend fun getSolvedMission(
        @Path("page") page: Int,
    ): GetSolveMissionResponse

    @GET("/user/scoring/{solveId}")
    suspend fun getDetailSolveMission(
        @Path("solveId") solveId: UUID,
    ): DetailSolveMissionResponse

    @POST("/user/scoring/{solveId}")
    suspend fun scoreSolveMission(
        @Path("solveId") solveId: UUID,
        @Body body: ScoreRequest,
    )
}