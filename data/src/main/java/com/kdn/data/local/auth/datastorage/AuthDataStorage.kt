package com.kdn.data.local.auth.datastorage

interface AuthDataStorage {
    fun setAccessToken(accessToken: String?)
    fun getAccessToken(): String?
    fun setRefreshToken(refreshToken: String?)
    fun getRefreshToken(): String?
    fun setExpiredAt(expiredAt: String?)
    fun getExpiredAt(): String?
}