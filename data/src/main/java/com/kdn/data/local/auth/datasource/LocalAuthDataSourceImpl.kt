package com.kdn.data.local.auth.datasource

import com.kdn.data.local.auth.datastorage.AuthPreference
import java.time.LocalDateTime
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(
    private val authPreferences: AuthPreference,
) : LocalAuthDataSource {
    override suspend fun getAccessToken(): String? =
        authPreferences.getAccessToken()

    override suspend fun setAccessToken(accessToken: String) =
        authPreferences.setAccessToken(accessToken = accessToken)

    override suspend fun getRefreshToken(): String? =
        authPreferences.getRefreshToken()

    override suspend fun setRefreshToken(refreshToken: String) =
        authPreferences.setRefreshToken(refreshToken = refreshToken)

    override suspend fun getExpiredAt(): LocalDateTime? =
        authPreferences.getExpiredAt()

    override suspend fun setExpiredAt(expiredAt: String) =
        authPreferences.setExpiredAt(expiredAt = expiredAt)

    override suspend fun getRoleInfo(): String? =
        authPreferences.getRoleInfo()

    override suspend fun setRoleInfo(role: String) =
        authPreferences.setRoleInfo(role = role)

    override suspend fun deleteRefreshToken() {

    }

    override suspend fun deleteExpiredAt() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAccessToken() {
        TODO("Not yet implemented")
    }
}