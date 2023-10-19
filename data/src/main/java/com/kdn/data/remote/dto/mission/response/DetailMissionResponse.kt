package com.kdn.data.remote.dto.mission.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.mission.DetailMissionEntity

data class DetailMissionResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("timeLimit")
    val timeLimit: Int,
)

fun DetailMissionResponse.toEntity() = DetailMissionEntity(
    title = title,
    timeLimit = timeLimit,
)