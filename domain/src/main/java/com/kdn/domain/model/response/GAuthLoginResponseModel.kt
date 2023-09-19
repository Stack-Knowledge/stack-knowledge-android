package com.kdn.domain.model.response

data class GAuthLoginResponseModel (
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: String,
    val authority: String,
)
