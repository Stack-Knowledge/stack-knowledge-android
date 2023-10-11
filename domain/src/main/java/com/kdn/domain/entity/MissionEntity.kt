package com.kdn.domain.entity

import java.util.UUID

data class MissionEntity(
    val id: UUID,
    val title: String,
    val point: Int,
    val missionStatus: String,
) {
    data class User(
        val id: UUID,
        val email: String,
        val name: String,
        val profileImage: String
    )
}