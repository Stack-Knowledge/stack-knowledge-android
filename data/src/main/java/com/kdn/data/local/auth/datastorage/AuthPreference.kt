package com.kdn.data.local.auth.datastorage

import java.time.LocalDateTime

interface AuthPreference {
    fun setAccessToken(accessToken: String?)
    fun getAccessToken(): String?
    fun setRefreshToken(refreshToken: String?)
    fun getRefreshToken(): String?
    fun setExpiredAt(expiredAt: String?)
    fun getExpiredAt(): LocalDateTime?
}