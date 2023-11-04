package com.kdn.data.repository.student

import com.kdn.data.remote.datasource.student.RemoteStudentDataSource
import com.kdn.data.remote.dto.student.response.toEntity
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.domain.entity.student.RankingEntity
import com.kdn.domain.repository.student.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteStudentDataSource,
) : StudentRepository {
    override suspend fun getRankingList(): List<RankingEntity> =
        remoteDataSource.getRankingList().map { it.toEntity() }

    override suspend fun getMyInfo(): MyInfoEntity =
        remoteDataSource.getMyInfo().toEntity()
}
