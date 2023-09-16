package com.kdn.domain.repository

import com.kdn.domain.model.request.GAuthLoginRequestModel
import com.kdn.domain.model.response.GAuthLoginResponseModel
import com.kdn.domain.model.response.RefreshTokenResponseModel
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun gAuthLogin(body: GAuthLoginRequestModel): Flow<GAuthLoginResponseModel>
    suspend fun saveTheLoginData(data: GAuthLoginResponseModel)
    suspend fun provideRefreshToken(refreshToken: String): Flow<RefreshTokenResponseModel>
}