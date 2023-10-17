package com.kdn.data.local.auth.datasource

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import com.kdn.data.local.key.AuthPreferenceKey
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.edit
import com.kdn.data.local.auth.datastorage.AuthPreference
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.prefs.Preferences
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

}