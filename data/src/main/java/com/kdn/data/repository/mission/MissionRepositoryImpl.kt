package com.kdn.data.repository.mission

import com.kdn.data.remote.datasource.mission.RemoteMissionDataSource
import com.kdn.data.remote.dto.mission.request.toRequest
import com.kdn.data.remote.dto.mission.response.toEntity
import com.kdn.domain.entity.mission.DetailMissionEntity
import com.kdn.domain.entity.mission.MissionEntity
import com.kdn.domain.param.mission.CreateMissionParam
import com.kdn.domain.repository.mission.MissionRepository
import java.util.UUID
import javax.inject.Inject

class MissionRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteMissionDataSource
) : MissionRepository {
    override suspend fun getMissionList(): List<MissionEntity> =
        remoteDataSource.getMissionList().map { it.toEntity() }

    override suspend fun getDetailMission(missionId: UUID): DetailMissionEntity =
        remoteDataSource.getDetailMission(missionId).toEntity()

    override suspend fun createMission(createMissionParam: CreateMissionParam) =
        remoteDataSource.createMission(createMissionParam.toRequest())
}