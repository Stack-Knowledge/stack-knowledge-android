package com.kdn.domain.repository.mission

import com.kdn.domain.entity.mission.DetailMissionEntity
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.domain.param.mission.CreateMissionParam
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface MissionRepository {
    suspend fun getMissionList(): List<MissionEntity>
    suspend fun getDetailMission(missionId: UUID): DetailMissionEntity
    suspend fun createMission(createMissionParam: CreateMissionParam)
}