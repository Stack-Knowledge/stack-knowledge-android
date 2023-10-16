package com.kdn.data.remote.datasource.mission

import com.kdn.data.remote.api.MissionAPI
import com.kdn.data.remote.dto.mission.request.CreateMissionRequest
import com.kdn.data.remote.dto.mission.response.DetailMissionResponse
import com.kdn.data.remote.dto.mission.response.MissionResponse
import com.kdn.data.utils.StackApiHandler
import java.util.UUID
import javax.inject.Inject

class RemoteMissionDataSourceImpl @Inject constructor(
    private val service: MissionAPI,
) : RemoteMissionDataSource {
    override suspend fun getMissionList(): List<MissionResponse> {
        return StackApiHandler<List<MissionResponse>>()
            .httpRequest { service.getMission() }
            .sendRequest()
    }

    override suspend fun getDetailMission(missionId: UUID): DetailMissionResponse {
        return StackApiHandler<DetailMissionResponse>()
            .httpRequest { service.getDetailMission(missionId) }
            .sendRequest()
    }

    override suspend fun createMission(createMissionRequest: CreateMissionRequest) {
        return StackApiHandler<Unit>()
            .httpRequest { service.createMission(createMissionRequest) }
            .sendRequest()
    }

}