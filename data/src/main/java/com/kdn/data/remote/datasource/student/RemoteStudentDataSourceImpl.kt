package com.kdn.data.remote.datasource.student

import com.kdn.data.remote.api.student.StudentAPI
import com.kdn.data.remote.dto.student.request.ChangeProfileImageRequest
import com.kdn.data.remote.dto.student.response.MyInfoResponse
import com.kdn.data.remote.dto.student.response.ProfileImageResponse
import com.kdn.data.remote.dto.student.response.RankingResponse
import com.kdn.data.utils.StackApiHandler
import okhttp3.MultipartBody
import javax.inject.Inject

class RemoteStudentDataSourceImpl @Inject constructor(
    private val service: StudentAPI,
) : RemoteStudentDataSource {
    override suspend fun getRankingList(): List<RankingResponse> {
        return StackApiHandler<List<RankingResponse>>()
            .httpRequest { service.getRankingList() }
            .sendRequest()
    }

    override suspend fun getMyInfo(): MyInfoResponse {
        return StackApiHandler<MyInfoResponse>()
            .httpRequest { service.getMyInfo() }
            .sendRequest()
    }

    override suspend fun changeProfileImage(image: MultipartBody.Part) {
        return StackApiHandler<Unit>()
            .httpRequest { service.updateProfileImage(image) }
            .sendRequest()
    }
}