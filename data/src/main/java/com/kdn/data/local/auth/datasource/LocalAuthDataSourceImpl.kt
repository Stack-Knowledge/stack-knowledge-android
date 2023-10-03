package com.kdn.data.local.auth.datasource

import androidx.datastore.core.DataStore
import com.kdn.data.local.key.AuthPreferenceKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import javax.inject.Inject

class LocalAuthDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : LocalAuthDataSource {
    override suspend fun getAccessToken(): Flow<String> = dataStore.data.map {
        it[AuthPreferenceKey.ACCESS_TOKEN] ?: ""
    }

    override suspend fun setAccessToken(accessToken: String) {
        dataStore.edit{
            it[AuthPreferenceKey.ACCESS_TOKEN] = accessToken
        }
    }

    override suspend fun removeAccessToken() {
        dataStore.edit {
            it.remove(AuthPreferenceKey.ACCESS_TOKEN)
        }
    }


    override suspend fun getRefreshToken(): Flow<String> = dataStore.data.map {
        it[AuthPreferenceKey.REFRESH_TOKEN] ?: ""
    }

    override suspend fun setRefreshToken(refreshToken: String) {
        dataStore.edit {
            it[AuthPreferenceKey.REFRESH_TOKEN] = refreshToken
        }
    }

    override suspend fun removeRefreshToken() {
        dataStore.edit {
            it.remove(AuthPreferenceKey.REFRESH_TOKEN)
        }
    }

    override suspend fun getExpiredAt(): Flow<String> = dataStore.data.map {
        it[AuthPreferenceKey.EXPIRE_AT] ?: ""
    }

    override suspend fun setExpiredAt(ExpiredAt: String) {
        dataStore.edit {
            it[AuthPreferenceKey.EXPIRE_AT] = ExpiredAt
        }
    }

    override suspend fun removeExpiredAt() {
        dataStore.edit {
            it.remove(AuthPreferenceKey.EXPIRE_AT)
        }
    }

    override suspend fun getAuthorityInfo(): Flow<String> = dataStore.data.map{
        it[AuthPreferenceKey.AUTHORITY] ?: ""
    }

    override suspend fun setAuthorityInfo(authority: String) {
        dataStore.edit {
            it[AuthPreferenceKey.AUTHORITY] = authority
        }
    }

    override suspend fun removeAuthorityInfo() {
        dataStore.edit {
            it.remove(AuthPreferenceKey.AUTHORITY)
        }
    }

}