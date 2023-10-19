package com.kdn.domain.usecase.mission

import com.kdn.domain.param.mission.CreateMissionParam
import com.kdn.domain.repository.mission.MissionRepository
import javax.inject.Inject

class CreateMissionUseCase @Inject constructor(
    private val missionRepository: MissionRepository,
) {
    suspend operator fun invoke(createMissionParam: CreateMissionParam) = kotlin.runCatching {
        missionRepository.createMission(createMissionParam)
    }
}