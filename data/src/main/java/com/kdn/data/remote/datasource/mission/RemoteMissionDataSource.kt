package com.kdn.data.remote.datasource.mission

import com.kdn.data.remote.dto.mission.request.CreateMissionRequest
import com.kdn.data.remote.dto.mission.response.DetailMissionResponse
import com.kdn.data.remote.dto.mission.response.MissionResponse
import java.util.UUID

interface RemoteMissionDataSource {
    suspend fun getMissionList(): List<MissionResponse>
    suspend fun getDetailMission(missionId: UUID): DetailMissionResponse
    suspend fun createMission(createMissionRequest: CreateMissionRequest)
}