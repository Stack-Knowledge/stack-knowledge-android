package com.kdn.data.repository.mission

import com.kdn.data.remote.datasource.mission.RemoteMissionDataSource
import com.kdn.data.remote.dto.mission.response.toEntity
import com.kdn.domain.entity.MissionEntity
import com.kdn.domain.repository.mission.MissionRepository
import javax.inject.Inject

class MissionRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteMissionDataSource
) : MissionRepository {
    override suspend fun getMissionList(): List<MissionEntity> =
        remoteDataSource.getMissionList().map {
            it.toEntity()
        }

}