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
}

fun MissionResponse.toMissionModel() = MissionResponseModel(
    id = id,
    title = title,
    point = point,
    missionStatus = missionStatus,
    user = DomainUser(id = user.id, email = user.email, name = user.name, profileImage = user.profileImage)
)