package com.kdn.domain.model.response

import java.util.UUID

data class RankingResponseModel(
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
    fun RankingResponseModel.User.toEntity() = RankingResponseModel.User(
        id = id,
        email = email,
        name = name,
        profileImage = profileImage,
    )
}