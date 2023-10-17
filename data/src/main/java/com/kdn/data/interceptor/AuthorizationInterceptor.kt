package com.kdn.data.interceptor

import android.util.Log
import com.google.gson.Gson
import com.kdn.data.BuildConfig
import com.kdn.data.local.auth.datastorage.AuthPreference
import com.kdn.data.remote.dto.auth.response.GAuthLoginResponse
import com.kdn.domain.exception.NeedLoginException
import com.kdn.domain.exception.UnknownException
import javax.inject.Inject
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.time.*
import java.time.format.DateTimeFormatter

class AuthorizationInterceptor @Inject constructor(
    private val authPreference: AuthPreference,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.e("인터셉터 호출", "성공")
        val request = chain.request()
        val path = request.url.encodedPath
        val ignorePath = listOf(
            "/auth",
        )
        if (ignorePath.contains(path)) return chain.proceed(request)
        val refreshToken = authPreference.getRefreshToken()
        Log.e("인터셉터", refreshToken.toString())
        if (!refreshToken.isNullOrBlank()) {
            Log.e("인터셉터", "김현승")
            val expiredAt = authPreference.getExpiredAt() ?: throw UnknownException(message = null)
            val currentTime = LocalDateTime.now(ZoneId.systemDefault())
            if (currentTime.isAfter(expiredAt)) {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("${BuildConfig.BASE_URL}/auth")
                    .post("".toRequestBody("application/json".toMediaTypeOrNull()))
                    .addHeader("refreshToken", "${authPreference.getRefreshToken()}")
                    .build()
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val token = Gson().fromJson(
                        response.body!!.string(),
                        GAuthLoginResponse::class.java
                    )
                    authPreference.setAccessToken(accessToken = token.accessToken)
                    authPreference.setRefreshToken(refreshToken = token.refreshToken)
                    authPreference.setExpiredAt(expiredAt = token.expiredAt)
                } else throw NeedLoginException("")
            }
            val accessToken = authPreference.getAccessToken()
            return chain.proceed(
                request.newBuilder()
                    .addHeader("Authorization", "Bearer $accessToken")
                    .build()
            )
        }
        return chain.proceed(request)
    }
}