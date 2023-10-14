package com.kdn.data.remote.datasource.mission

import com.kdn.data.remote.api.MissionAPI
import com.kdn.data.remote.dto.mission.response.MissionResponse
import com.kdn.data.utils.StackApiHandler
import javax.inject.Inject

class RemoteMissionDataSourceImpl @Inject constructor(
    private val service: MissionAPI,
) : RemoteMissionDataSource {
    override suspend fun getMissionList(): List<MissionResponse> {
        return StackApiHandler<List<MissionResponse>>()
            .httpRequest { service.getMission() }
            .sendRequest()
    }

}