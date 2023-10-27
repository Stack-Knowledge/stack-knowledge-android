package com.kdn.data.remote.datasource.user

import com.kdn.data.remote.dto.user.response.DetailSolveMissionResponse
import com.kdn.data.remote.dto.user.response.GetSolveMissionResponse
import com.kdn.domain.entity.user.DetailSolveMissionEntity
import com.kdn.domain.entity.user.GetSolveMissionEntity
import java.util.UUID

interface RemoteUserDataSource {
    suspend fun getSolvedMission(): List<GetSolveMissionResponse>
    suspend fun getDetailSolveMission(solveId: UUID): DetailSolveMissionResponse
    suspend fun scoreSolveMission()
}