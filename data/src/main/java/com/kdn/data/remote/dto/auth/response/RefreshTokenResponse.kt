package com.kdn.data.remote.dto.auth.response

import com.kdn.domain.model.response.RefreshTokenResponseModel

data class RefreshTokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String,
)

fun RefreshTokenResponse.toRefreshModel() =
    RefreshTokenResponseModel(
        accessToken = accessToken,
        refreshToken = refreshToken,
        expiredAt = expiredAt,
    )