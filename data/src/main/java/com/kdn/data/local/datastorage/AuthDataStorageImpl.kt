package com.kdn.data.local.datastorage

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AuthDataStorageImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AuthDataStorage {

    companion object {
        const val NAME = "TokenInfo"
        const val ACCESS_TOKEN = "accessToken"
        const val REFRESH_TOKEN = "refreshToken"
        const val EXPIRED_AT = "expiredAt"
    }
    override fun setAccessToken(accessToken: String) {

    }

    override fun getAccessToken(): String {
        TODO("Not yet implemented")
    }

    override fun setRefreshToken(refreshToken: String) {
        TODO("Not yet implemented")
    }

    override fun getRefreshToken(): String {
        TODO("Not yet implemented")
    }

    override fun setExpiredAt(expiredAt: String) {
        TODO("Not yet implemented")
    }

    override fun getExpiredAt(): String {
        TODO("Not yet implemented")
    }

}