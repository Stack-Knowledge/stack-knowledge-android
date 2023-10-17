package com.kdn.domain.entity.user

import java.util.UUID

data class UserEntity(
    val id: UUID,
    val email: String,
    val name: String,
    val profileImage: String,
)
