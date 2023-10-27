package com.kdn.data.repository.user

import com.kdn.data.remote.datasource.user.RemoteUserDataSource
import com.kdn.data.remote.dto.user.response.toEntity
import com.kdn.domain.entity.user.DetailSolveMissionEntity
import com.kdn.domain.entity.user.GetSolveMissionEntity
import com.kdn.domain.repository.user.UserRepository
import java.util.UUID
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteUserDataSource
) : UserRepository {
    override suspend fun getSolvedMission(): List<GetSolveMissionEntity> =
        remoteDataSource.getSolvedMission().map { it.toEntity() }

    override suspend fun getDetailSolveMission(solveId: UUID): DetailSolveMissionEntity =
        remoteDataSource.getDetailSolveMission(solveId).toEntity()

    override suspend fun scoreSolveMission() {
        TODO("Not yet implemented")
    }
}