package com.kdn.domain.usecase.mission

import com.kdn.domain.repository.mission.MissionRepository
import javax.inject.Inject

class GetMissionListUseCase @Inject constructor(
    private val missionRepository: MissionRepository
){
    suspend operator fun invoke() = kotlin.runCatching {
        missionRepository.getMissionList()
    }
}