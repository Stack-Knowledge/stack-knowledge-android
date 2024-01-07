package com.kdn.data.local.auth.datasource

import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime


interface LocalAuthDataSource {
    suspend fun getAccessToken(): String?
    suspend fun setAccessToken(accessToken: String)
    suspend fun getRefreshToken():String?
    suspend fun setRefreshToken(refreshToken: String)
    suspend fun getExpiredAt(): LocalDateTime?
    suspend fun setExpiredAt(expiredAt: String)
    suspend fun getRoleInfo(): String?
    suspend fun setRoleInfo(role: String)
    suspend fun deleteRefreshToken()
    suspend fun deleteExpiredAt()
    suspend fun deleteAccessToken()
}