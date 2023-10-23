package com.kdn.data.remote.api.student

import com.kdn.data.remote.dto.student.response.MyInfoResponse
import com.kdn.data.remote.dto.student.response.RankingResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentAPI {
    @GET("/student/ranking")
    suspend fun getRankingList() : List<RankingResponse>

    @GET("/student/my")
    suspend fun getMyInfo() : MyInfoResponse

    @POST("/student/image")
    suspend fun updateProfileImage()
}