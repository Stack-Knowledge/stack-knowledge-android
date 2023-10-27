package com.kdn.domain.repository.user

import com.kdn.domain.entity.user.DetailSolveMissionEntity
import com.kdn.domain.entity.user.GetSolveMissionEntity
import java.util.UUID

interface UserRepository {
    suspend fun getSolvedMission(): List<GetSolveMissionEntity>
    suspend fun getDetailSolveMission(solveId: UUID): DetailSolveMissionEntity
    suspend fun scoreSolveMission()

}