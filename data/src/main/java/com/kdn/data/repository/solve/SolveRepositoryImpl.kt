package com.kdn.data.repository.solve

import com.kdn.data.remote.datasource.solve.RemoteSolveDataSource
import com.kdn.data.remote.dto.solve.request.toRequest
import com.kdn.domain.param.solve.SolveParam
import com.kdn.domain.repository.solve.SolveRepository
import java.util.UUID
import javax.inject.Inject

class SolveRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteSolveDataSource,
) : SolveRepository {
    override suspend fun solveMission(missionId: UUID, solveParam: SolveParam) {
        remoteDataSource.solveMission(missionId = missionId, solveParam.toRequest())
    }
}