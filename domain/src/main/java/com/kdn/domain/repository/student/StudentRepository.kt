package com.kdn.domain.repository.student

import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.domain.entity.student.RankingEntity
import com.kdn.domain.param.student.ChangeProfileImageParam

interface StudentRepository {
    suspend fun getRankingList(): List<RankingEntity>
    suspend fun getMyInfo(): MyInfoEntity
    suspend fun changeProfileImage(changeProfileImageParam: ChangeProfileImageParam)
}