package com.kdn.data.remote.dto.user.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.user.GetSolveMissionEntity
import java.util.UUID

data class GetSolveMissionResponse(
    @SerializedName("solveId")
    val solveId: UUID,
    @SerializedName("solveStatus")
    val solveStatus: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("point")
    val point: Int,
    @SerializedName("user")
    val user: User,
) {
    data class User(
        @SerializedName("id")
        val id: UUID,
        @SerializedName("email")
        val email: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("profileImage")
        val profileImage: String?,
    )
}

fun GetSolveMissionResponse.toEntity() = GetSolveMissionEntity(
    solveId = solveId,
    solveStatus = solveStatus,
    title = title,
    point = point,
    user = GetSolveMissionEntity.User(
        id = user.id,
        email = user.email,
        name = user.name,
        profileImage = user.profileImage,
    )
)