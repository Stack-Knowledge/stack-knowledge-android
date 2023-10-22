package com.kdn.data.remote.datasource.student

import com.kdn.data.remote.api.student.StudentAPI
import com.kdn.data.remote.dto.student.response.MyInfoResponse
import com.kdn.data.remote.dto.student.response.RankingResponse
import com.kdn.data.utils.StackApiHandler
import javax.inject.Inject

class RemoteStudentDataSourceImpl @Inject constructor(
    private val service: StudentAPI,
) : RemoteStudentDataSource {
    override suspend fun getRankingList(): List<RankingResponse> {
        return StackApiHandler<List<RankingResponse>>()
            .httpRequest { service.getRankingList() }
            .sendRequest()
    }

    override suspend fun getMyInfo(): List<MyInfoResponse> {
        return StackApiHandler<List<MyInfoResponse>>()
            .httpRequest { service.getMyInfo() }
            .sendRequest()
    }
}