package com.kdn.data.remote.dto.mission.request

import com.google.gson.annotations.SerializedName
import com.kdn.domain.param.mission.CreateMissionParam

data class CreateMissionRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("timeLimit")
    val timeLimit: Int,
)

fun CreateMissionParam.toRequest() = CreateMissionRequest(
    title = title,
    content = content,
    timeLimit = timeLimit,
)