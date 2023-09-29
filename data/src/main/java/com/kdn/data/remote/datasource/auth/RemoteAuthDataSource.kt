package com.kdn.data.remote.datasource.auth

import com.kdn.data.remote.dto.auth.request.GAuthLoginRequest
import com.kdn.data.remote.dto.auth.response.GAuthLoginResponse
import com.kdn.data.remote.dto.auth.response.RefreshTokenResponse
import kotlinx.coroutines.flow.Flow

interface RemoteAuthDataSource {
    suspend fun gAuthLogin(body: GAuthLoginRequest): Flow<GAuthLoginResponse>
    suspend fun refreshToken(refreshToken: String): Flow<RefreshTokenResponse>
}