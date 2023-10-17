package com.kdn.data.local.auth.datastorage

import android.content.SharedPreferences
import android.util.Log
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class AuthPreferenceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) : AuthPreference {

    companion object {
        const val ACCESS_TOKEN = "accessToken"
        const val REFRESH_TOKEN = "refreshToken"
        const val EXPIRED_AT = "expiredAt"
    }

    override fun setAccessToken(accessToken: String?) =
        setData(ACCESS_TOKEN, accessToken)

    override fun getAccessToken(): String? =
        sharedPreferences.getString(ACCESS_TOKEN, "")

    override fun setRefreshToken(refreshToken: String?) =
        setData(REFRESH_TOKEN, refreshToken)

    override fun getRefreshToken(): String? =
        sharedPreferences.getString(REFRESH_TOKEN, "")

    override fun setExpiredAt(expiredAt: String?) =
        setData(EXPIRED_AT, expiredAt)

    override fun getExpiredAt(): LocalDateTime? = let {
        sharedPreferences.getString(EXPIRED_AT, null)?.let {
            Log.e("getExpiredAt", it)
            LocalDateTime.parse(it, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss"))
        }
    }

    private fun setData(id: String, data: String?) =
        sharedPreferences.edit().let {
            it.putString(id, data)
            it.apply()
        }
}