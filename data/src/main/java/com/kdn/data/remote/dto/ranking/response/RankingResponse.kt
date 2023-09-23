package com.kdn.data.remote.dto.ranking.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.model.response.RankingResponseModel
import java.util.UUID
import com.kdn.domain.model.response.RankingResponseModel.User as DomainUser


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

fun RankingResponse.toRankingModel() = RankingResponseModel (
    id = id,
    cumulatePoint = cumulatePoint,
    user = DomainUser(id = user.id, email = user.email, name = user.name, profileImage = user.profileImage)
)
