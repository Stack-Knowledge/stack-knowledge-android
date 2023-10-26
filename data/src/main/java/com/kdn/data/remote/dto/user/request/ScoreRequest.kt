package com.kdn.data.remote.dto.user.request

import com.google.gson.annotations.SerializedName

data class ScoreRequest(
    @SerializedName("solveStatus")
    val solveStatus: String,
)
