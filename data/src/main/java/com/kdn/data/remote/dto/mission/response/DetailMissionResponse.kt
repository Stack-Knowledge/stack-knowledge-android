package com.kdn.data.remote.dto.mission.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.DetailMissionEntity

data class DetailMissionResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("timeLimit")
    val timeLimit: Int,
)

fun DetailMissionResponse.toEntity() = DetailMissionEntity(
    title = title,
    content = content,
    timeLimit = timeLimit,
)