package com.kdn.domain.model.response.auth

data class RefreshTokenResponseModel(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String,
)
