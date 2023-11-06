package com.kdn.domain.entity.user

import java.util.UUID

data class DetailSolveMissionEntity (
    val solveId: UUID,
    val title: String,
    val solvation: String,
)