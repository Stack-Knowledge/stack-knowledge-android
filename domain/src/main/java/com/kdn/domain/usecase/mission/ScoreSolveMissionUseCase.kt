package com.kdn.domain.usecase.mission

import com.kdn.domain.param.user.ScoreParam
import com.kdn.domain.repository.user.UserRepository
import java.util.UUID
import javax.inject.Inject

class ScoreSolveMissionUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(solveId: UUID, scoreParam: ScoreParam) = kotlin.runCatching {
        userRepository.scoreSolveMission(solveId, scoreParam)
    }
}