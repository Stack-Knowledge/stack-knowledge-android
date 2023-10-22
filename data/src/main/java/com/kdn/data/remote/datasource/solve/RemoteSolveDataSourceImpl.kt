package com.kdn.data.remote.datasource.solve

import com.kdn.data.remote.api.solve.SolveAPI
import com.kdn.data.remote.dto.solve.request.SolveRequest
import com.kdn.data.utils.StackApiHandler
import java.util.UUID
import javax.inject.Inject

class RemoteSolveDataSourceImpl @Inject constructor(
    private val service: SolveAPI,
) : RemoteSolveDataSource {
    override suspend fun solveMission(missionId: UUID, body: SolveRequest) {
        return StackApiHandler<Unit>()
            .httpRequest { service.solveMission(missionId = missionId, body = body) }
            .sendRequest()
    }
}