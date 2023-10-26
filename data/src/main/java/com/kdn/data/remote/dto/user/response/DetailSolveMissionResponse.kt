package com.kdn.data.remote.dto.user.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.mission.DetailMissionEntity
import com.kdn.domain.entity.user.DetailSolveMissionEntity
import java.util.UUID

data class DetailSolveMissionResponse(
    @SerializedName("solveId")
    val solveId: UUID,
    @SerializedName("title")
    val title: String,
    @SerializedName("solvation")
    val solvation: String,
)

fun DetailSolveMissionResponse.toEntity() = DetailSolveMissionEntity(
    solveId = solveId,
    title = title,
    solvation = solvation,
)