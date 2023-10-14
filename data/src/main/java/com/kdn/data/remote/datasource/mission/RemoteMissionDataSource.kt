package com.kdn.data.remote.datasource.mission

import com.kdn.data.remote.dto.mission.response.MissionResponse

interface RemoteMissionDataSource {
    suspend fun getMissionList(): List<MissionResponse>
}