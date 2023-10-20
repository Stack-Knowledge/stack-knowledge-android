package com.kdn.data.remote.api

import com.kdn.data.remote.dto.student.response.RankingResponse
import retrofit2.http.GET

interface StudentAPI {
    @GET("/student/ranking")
    suspend fun getRankingList() : List<RankingResponse>
}