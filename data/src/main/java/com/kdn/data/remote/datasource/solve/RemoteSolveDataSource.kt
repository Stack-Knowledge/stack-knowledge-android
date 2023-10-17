package com.kdn.data.remote.datasource.solve

import com.kdn.data.remote.dto.solve.request.SolveRequest
import java.util.UUID

interface RemoteSolveDataSource {
    suspend fun solveMission(missionId: UUID, body: SolveRequest)
}