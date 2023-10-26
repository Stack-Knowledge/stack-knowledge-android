package com.kdn.data.remote.dto.user.response

import com.google.gson.annotations.SerializedName
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
