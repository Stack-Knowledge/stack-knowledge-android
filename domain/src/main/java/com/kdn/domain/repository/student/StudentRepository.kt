package com.kdn.domain.repository.student

import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.domain.entity.student.RankingEntity
import okhttp3.MultipartBody

interface StudentRepository {
    suspend fun getRankingList(): List<RankingEntity>
    suspend fun getMyInfo(): MyInfoEntity
    suspend fun changeProfileImage(image: MultipartBody.Part)
}