package com.kdn.domain.repository.student

import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.domain.entity.student.RankingEntity

interface StudentRepository {
    suspend fun getRankingList(): List<RankingEntity>
    suspend fun getMyInfo(): MyInfoEntity
}