package com.kdn.domain.usecase.mission

import com.kdn.domain.repository.mission.MissionRepository
import java.util.UUID
import javax.inject.Inject

class GetDetailMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository,
) {
    suspend operator fun invoke(missionId: UUID) = kotlin.runCatching {
        missionRepository.getDetailMission(missionId)
    }
}