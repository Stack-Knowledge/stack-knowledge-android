package com.kdn.domain.param.mission

data class CreateMissionParam(
    val title: String,
    val content: String,
    val timeLimit: Int,
)
