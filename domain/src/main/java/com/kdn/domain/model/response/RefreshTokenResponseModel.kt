package com.kdn.domain.model.response

data class RefreshTokenResponseModel(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String,
)
