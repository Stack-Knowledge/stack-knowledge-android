package com.kdn.data.remote.datasource.student

import com.kdn.data.remote.dto.student.response.RankingResponse

interface RemoteStudentDataSource {
    suspend fun getRankingList(): List<RankingResponse>
}