package com.kdn.data.remote.api.student

import com.kdn.data.remote.dto.order.request.UpdateOrderedRequest
import com.kdn.data.remote.dto.student.request.ChangeProfileImageRequest
import com.kdn.data.remote.dto.student.response.MyInfoResponse
import com.kdn.data.remote.dto.student.response.ProfileImageResponse
import com.kdn.data.remote.dto.student.response.RankingResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST

interface StudentAPI {
    @GET("/student/ranking")
    suspend fun getRankingList() : List<RankingResponse>

    @GET("/student/my")
    suspend fun getMyInfo() : MyInfoResponse

    @POST("/student/image")
    suspend fun updateProfileImage(
        @Body changeProfileImageRequest: ChangeProfileImageRequest,
    ): ProfileImageResponse
}