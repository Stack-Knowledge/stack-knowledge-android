package com.kdn.domain.repository.user

interface UserRepository {
    suspend fun getSolvedMission()
    suspend fun getDetailSolveMission()
    suspend fun scoreSolveMission()

}