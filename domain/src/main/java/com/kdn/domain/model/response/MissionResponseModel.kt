package com.kdn.domain.model.response

import java.util.UUID

data class MissionResponseModel(
    val id: UUID,
    val title: String,
    val point: Int,
    val missionStatus: String,
    val user: User,
) {
    data class User(
        val id: UUID,
        val email: String,
        val name: String,
        val profileImage: String
    )

    fun User.toEntity() = MissionResponseModel.User(
        id = id,
        email = email,
        name = name,
        profileImage = profileImage,
    )
}