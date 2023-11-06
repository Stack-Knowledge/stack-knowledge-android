package com.kdn.domain.repository.auth

import com.kdn.domain.model.request.auth.GAuthLoginRequestModel
import com.kdn.domain.model.response.auth.GAuthLoginResponseModel
import com.kdn.domain.model.response.auth.RefreshTokenResponseModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun gAuthLogin(body: GAuthLoginRequestModel): Flow<GAuthLoginResponseModel>
    suspend fun saveTheLoginData(data: GAuthLoginResponseModel)
    suspend fun provideRefreshToken(refreshToken: String): Flow<RefreshTokenResponseModel>
    suspend fun getRoleInfo(): String
    suspend fun autoLogin(): String?
}