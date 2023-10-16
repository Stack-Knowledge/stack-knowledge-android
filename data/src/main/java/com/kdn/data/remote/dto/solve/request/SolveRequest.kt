package com.kdn.data.remote.dto.solve.request

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class SolveRequest(
    @SerializedName("missionId")
    val missionId: UUID,
    @SerializedName("solvation")
    val solvation: String,
)