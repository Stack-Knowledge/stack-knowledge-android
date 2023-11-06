package com.kdn.data.repository.student

import com.kdn.data.remote.datasource.student.RemoteStudentDataSource
import com.kdn.data.remote.dto.student.request.toRequest
import com.kdn.data.remote.dto.student.response.toEntity
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.domain.entity.student.RankingEntity
import com.kdn.domain.param.student.ChangeProfileImageParam
import com.kdn.domain.repository.student.StudentRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteStudentDataSource,
) : StudentRepository {
    override suspend fun getRankingList(): List<RankingEntity> =
        remoteDataSource.getRankingList().map { it.toEntity() }

    override suspend fun getMyInfo(): MyInfoEntity =
        remoteDataSource.getMyInfo().toEntity()

    override suspend fun changeProfileImage(image: MultipartBody.Part) =
        remoteDataSource.changeProfileImage(image = image)
}
