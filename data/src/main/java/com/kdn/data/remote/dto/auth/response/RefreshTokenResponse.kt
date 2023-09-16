package com.kdn.data.remote.dto.auth.response

data class RefreshTokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String,
)

fun RefreshTokenResponse.toLoginModel() =
    RefreshTokenResponse(
        accessToken = accessToken,
        refreshToken = refreshToken,
        expiredAt = expiredAt,
    )