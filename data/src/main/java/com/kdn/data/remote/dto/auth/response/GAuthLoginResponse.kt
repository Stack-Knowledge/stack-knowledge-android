package com.kdn.data.remote.dto.auth.response

import com.kdn.domain.model.response.auth.GAuthLoginResponseModel

data class GAuthLoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String,
    val authority: String,
)

fun GAuthLoginResponse.toLoginModel() =
    GAuthLoginResponseModel(
        accessToken = this.accessToken,
        refreshToken = this.refreshToken,
        expiredAt = this.expiredAt,
        authority = this.authority,
    )