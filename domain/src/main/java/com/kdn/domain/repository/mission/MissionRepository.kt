package com.kdn.domain.repository.mission

import com.kdn.domain.entity.MissionEntity

interface MissionRepository {
    suspend fun getMissionList(): List<MissionEntity>

}