package com.kdn.data.remote.datasource.auth

import com.kdn.data.remote.api.auth.AuthAPI
import com.kdn.data.remote.dto.auth.request.GAuthLoginRequest
import com.kdn.data.remote.dto.auth.response.GAuthLoginResponse
import com.kdn.data.remote.dto.auth.response.RefreshTokenResponse
import com.kdn.data.utils.StackApiHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteAuthDataSourceImpl @Inject constructor(
    private val service: AuthAPI,
) : RemoteAuthDataSource {
    override suspend fun gAuthLogin(body: GAuthLoginRequest): Flow<GAuthLoginResponse> = flow {
        emit(
            StackApiHandler<GAuthLoginResponse>()
                .httpRequest { service.gAuthLogin(body = body) }
                .sendRequest()
        )
    }

    override suspend fun refreshToken(refreshToken: String): Flow<RefreshTokenResponse> = flow {
        emit(
            StackApiHandler<RefreshTokenResponse>()
                .httpRequest { service.provideAccessToken("Bearer $refreshToken") }
                .sendRequest()
        )
    }
}