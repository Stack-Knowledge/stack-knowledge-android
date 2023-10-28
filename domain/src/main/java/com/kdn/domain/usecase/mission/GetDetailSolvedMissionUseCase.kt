package com.kdn.domain.usecase.mission

import com.kdn.domain.repository.user.UserRepository
import java.util.UUID
import javax.inject.Inject

class GetDetailSolvedMissionUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(solveId: UUID) = kotlin.runCatching {
        userRepository.getDetailSolveMission(solveId)
    }
}