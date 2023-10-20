package com.kdn.data.remote.api

import com.kdn.data.remote.dto.solve.request.SolveRequest
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.UUID

interface SolveAPI {
    @POST("/solve/{missionId}")
    suspend fun solveMission(
        @Path("missionId") missionId: UUID,
        @Body body: SolveRequest,
    )
}