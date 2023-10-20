package com.kdn.domain.entity.student

import java.util.UUID

data class RankingEntity(
    val id: UUID,
    val cumulatePoint: Int,
    val user: User,
) {
    data class User(
        val id: UUID,
        val email: String,
        val name: String,
        val profileImage: String?,
    )
}
