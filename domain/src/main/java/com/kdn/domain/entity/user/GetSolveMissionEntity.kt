package com.kdn.domain.entity.user

import java.util.UUID

data class GetSolveMissionEntity(
    val solveId: UUID,
    val solveStatus: String,
    val title: String,
    val point: Int,
    val user: User,
) {
    data class User(
        val id: UUID,
        val email: String,
        val name: String,
        val profileImage: String?,
    )
}