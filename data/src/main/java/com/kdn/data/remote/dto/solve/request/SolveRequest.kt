package com.kdn.data.remote.dto.solve.request

import com.google.gson.annotations.SerializedName
import com.kdn.domain.param.solve.SolveParam

data class SolveRequest(
    @SerializedName("solvation")
    val solvation: String,
)

fun SolveParam.toRequest() = SolveRequest(
    solvation = solvation,
)