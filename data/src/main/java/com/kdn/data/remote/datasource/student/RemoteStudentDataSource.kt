package com.kdn.data.remote.datasource.student

import com.kdn.data.remote.dto.student.request.ChangeProfileImageRequest
import com.kdn.data.remote.dto.student.response.MyInfoResponse
import com.kdn.data.remote.dto.student.response.RankingResponse
import okhttp3.MultipartBody

interface RemoteStudentDataSource {
    suspend fun getRankingList(): List<RankingResponse>
    suspend fun getMyInfo(): MyInfoResponse
    suspend fun changeProfileImage(image: MultipartBody.Part)
}