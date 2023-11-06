package com.kdn.data.repository.auth

import android.util.Log
import com.kdn.data.local.auth.datasource.LocalAuthDataSource
import com.kdn.data.remote.datasource.auth.RemoteAuthDataSource
import com.kdn.data.remote.dto.auth.request.GAuthLoginRequest
import com.kdn.data.remote.dto.auth.response.toLoginModel
import com.kdn.data.remote.dto.auth.response.toRefreshModel
import com.kdn.domain.model.request.auth.GAuthLoginRequestModel
import com.kdn.domain.model.response.auth.GAuthLoginResponseModel
import com.kdn.domain.model.response.auth.RefreshTokenResponseModel
import com.kdn.domain.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteAuthDataSource,
    private val localDataSource: LocalAuthDataSource,
) : AuthRepository {
    override suspend fun gAuthLogin(body: GAuthLoginRequestModel): Flow<GAuthLoginResponseModel> {
        return remoteDataSource.gAuthLogin(
            body = GAuthLoginRequest(
                code = body.code
            )
        ).map { it.toLoginModel() }
    }

    override suspend fun saveTheLoginData(data: GAuthLoginResponseModel) {
        Log.e("저장 expiredAt", data.expiredAt)
        data.let {
            localDataSource.setAccessToken(it.accessToken)
            localDataSource.setRefreshToken(it.refreshToken)
            localDataSource.setExpiredAt(it.expiredAt)
            localDataSource.setRoleInfo(it.authority)
        }
    }

    override suspend fun provideRefreshToken(refreshToken: String): Flow<RefreshTokenResponseModel> {
        return flow {
            remoteDataSource.refreshToken(refreshToken).collect {
                emit(it.toRefreshModel())
            }
        }
    }

    override suspend fun getRoleInfo(): Flow<String> {
        TODO("Not yet implemented")
    }
}