package com.kdn.domain.repository.solve

import com.kdn.domain.param.solve.SolveParam
import java.util.UUID

interface SolveRepository {
    suspend fun solveMission(missionId: UUID, solveParam: SolveParam)
}