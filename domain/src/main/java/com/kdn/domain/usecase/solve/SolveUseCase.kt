package com.kdn.domain.usecase.solve

import com.kdn.domain.param.solve.SolveParam
import com.kdn.domain.repository.solve.SolveRepository
import java.util.UUID
import javax.inject.Inject

class SolveUseCase @Inject constructor(
    private val solveRepository: SolveRepository,
) {
    suspend operator fun invoke(missionId: UUID, solveParam: SolveParam) = kotlin.runCatching {
        solveRepository.solveMission(missionId, solveParam)
    }
}