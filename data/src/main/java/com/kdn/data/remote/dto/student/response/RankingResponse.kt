package com.kdn.data.remote.dto.student.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.student.RankingEntity
import java.util.UUID


data class RankingResponse (
    @SerializedName("id")
    val id: UUID,
    @SerializedName("cumulatePoint")
    val cumulatePoint: Int,
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
        val profileImage: String?
    )
}

fun RankingResponse.toEntity() = RankingEntity(
    id = id,
    cumulatePoint = cumulatePoint,
    user = RankingEntity.User(
        id = user.id,
        email = user.email,
        name = user.name,
        profileImage = user.profileImage
    )
)