package com.kdn.data.remote.api.auth

import com.kdn.data.remote.dto.auth.request.GAuthLoginRequest
import com.kdn.data.remote.dto.auth.response.GAuthLoginResponse
import com.kdn.data.remote.dto.auth.response.RefreshTokenResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthAPI {

    @POST("/auth")
    suspend fun gAuthLogin(
        @Body body: GAuthLoginRequest,
    ): GAuthLoginResponse

    @PATCH("/auth")
    suspend fun provideAccessToken(
        @Header ("refreshToken") refreshToken: String,
    ): RefreshTokenResponse

    @DELETE("/auth")
    suspend fun logout(
        @Header("refreshToken") refreshToken: String,
    )
}