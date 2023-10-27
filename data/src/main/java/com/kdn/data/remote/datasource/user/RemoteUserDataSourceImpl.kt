package com.kdn.data.remote.datasource.user

import com.kdn.data.remote.api.user.UserAPI
import com.kdn.data.remote.dto.user.response.DetailSolveMissionResponse
import com.kdn.data.remote.dto.user.response.GetSolveMissionResponse
import com.kdn.data.utils.StackApiHandler
import com.kdn.domain.entity.user.DetailSolveMissionEntity
import com.kdn.domain.entity.user.GetSolveMissionEntity
import java.util.UUID
import javax.inject.Inject

class RemoteUserDataSourceImpl @Inject constructor(
    private val service: UserAPI,
) : RemoteUserDataSource {
    override suspend fun getSolvedMission(): List<GetSolveMissionResponse> {
        return StackApiHandler<List<GetSolveMissionResponse>>()
            .httpRequest { service.getSolvedMission() }
            .sendRequest()
    }


    override suspend fun getDetailSolveMission(solveId: UUID): DetailSolveMissionResponse {
        return StackApiHandler<DetailSolveMissionResponse>()
            .httpRequest { service.getDetailSolveMission(solveId) }
            .sendRequest()
    }

    override suspend fun scoreSolveMission() {
        TODO("Not yet implemented")
    }
}