package com.kdn.data.remote.dto.mission.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.model.response.MissionResponseModel
import java.util.UUID
import com.kdn.domain.model.response.MissionResponseModel.User as DomainUser

data class MissionResponse(
    @SerializedName("id")
    val id: UUID,
    @SerializedName("title")
    val title: String,
    @SerializedName("point")
    val point: Int,
    @SerializedName("missionStatus")
    val missionStatus: String,
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
        val profileImage: String
    )
}

fun MissionResponse.toMissionModel() = MissionResponseModel(
    id = id,
    title = title,
    point = point,
    missionStatus = missionStatus,
    user = DomainUser(id = user.id, email = user.email, name = user.name, profileImage = user.profileImage)
)