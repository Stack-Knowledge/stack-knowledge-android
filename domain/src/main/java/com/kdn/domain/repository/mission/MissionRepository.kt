package com.kdn.domain.repository.mission

import com.kdn.domain.entity.DetailMissionEntity
import com.kdn.domain.entity.MissionEntity
import com.kdn.domain.param.mission.CreateMissionParam
import java.util.UUID

interface MissionRepository {
    suspend fun getMissionList(): List<MissionEntity>
    suspend fun getDetailMission(missionId: UUID): DetailMissionEntity
    suspend fun createMission(createMissionParam: CreateMissionParam)
}