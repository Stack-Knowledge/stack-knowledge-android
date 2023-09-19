package com.kdn.data.repository

import com.kdn.data.local.datasource.LocalAuthDataSource
import com.kdn.data.remote.datasource.RemoteAuthDataSource
import com.kdn.data.remote.dto.auth.request.GAuthLoginRequest
import com.kdn.data.remote.dto.auth.response.toLoginModel
import com.kdn.data.remote.dto.auth.response.toRefreshModel
import com.kdn.domain.model.request.GAuthLoginRequestModel
import com.kdn.domain.model.response.GAuthLoginResponseModel
import com.kdn.domain.model.response.RefreshTokenResponseModel
import com.kdn.domain.repository.AuthRepository
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
        data.let {
            localDataSource.setAccessToken(it.accessToken)
            localDataSource.setRefreshToken(it.refreshToken)
            localDataSource.setExpiredAt(it.expiredAt)
        }
    }

    override suspend fun provideRefreshToken(refreshToken: String): Flow<RefreshTokenResponseModel> {
        return flow{
            remoteDataSource.refreshToken(refreshToken).collect {
                emit(it.toRefreshModel())
            }
        }
    }

    override suspend fun getAuthorityInfo(): Flow<String> {
        return localDataSource.getAuthorityInfo()
    }

    override suspend fun deleteLoginData() {
        localDataSource.removeAccessToken()
        localDataSource.removeRefreshToken()
        localDataSource.removeExpiredAt()
        localDataSource.removeAuthorityInfo()
    }

}