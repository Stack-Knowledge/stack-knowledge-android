package com.kdn.data.remote.dto.user.request

import com.google.gson.annotations.SerializedName
import com.kdn.domain.param.user.ScoreParam

data class ScoreRequest(
    @SerializedName("solveStatus")
    val solveStatus: String,
)

fun ScoreParam.toRequest() = ScoreRequest(
    solveStatus = solveStatus,
)