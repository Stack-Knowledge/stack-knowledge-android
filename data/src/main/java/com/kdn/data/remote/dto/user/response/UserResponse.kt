package com.kdn.data.remote.dto.user.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.user.UserEntity
import java.util.UUID

data class UserResponse(
    @SerializedName("id")
    val id: UUID,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("profileImage")
    val profileImage: String,
    )
fun UserResponse.toEntity() = UserEntity(
    id = id,
    email = email,
    name = name,
    profileImage = profileImage,
)
