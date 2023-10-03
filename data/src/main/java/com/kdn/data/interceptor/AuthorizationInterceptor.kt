package com.kdn.data.interceptor

import com.google.gson.Gson
import com.kdn.data.BuildConfig
import com.kdn.data.local.auth.datastorage.AuthDataStorage
import com.kdn.data.remote.dto.auth.response.GAuthLoginResponse
import com.kdn.domain.exception.NeedLoginException
import javax.inject.Inject
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.time.*
import java.time.format.DateTimeFormatter

class AuthorizationInterceptor @Inject constructor(
    private val authDataStorage: AuthDataStorage
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath
        val ignorePath = listOf(
            "/mission",
            "/auth",
            "/solve",
            "/user/scoring",
            "/student/image",
            "/order"
        )
        if (ignorePath.contains(path)) return chain.proceed(request)
        val refreshToken = authDataStorage.getRefreshToken()
        if (!refreshToken.isNullOrBlank()) {
            val expiredAt = LocalDateTime.parse(
                authDataStorage.getExpiredAt(),
                DateTimeFormatter.ISO_ZONED_DATE_TIME
            )
            val currentTime = LocalDateTime.now(ZoneId.systemDefault())
            if (currentTime.isAfter(expiredAt)) {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("${BuildConfig.BASE_URL}/auth")
                    .post("".toRequestBody("application/json".toMediaTypeOrNull()))
                    .addHeader("refreshToken", "${authDataStorage.getRefreshToken()}")
                    .build()
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    val token = Gson().fromJson(
                        response.body!!.string(),
                        GAuthLoginResponse::class.java
                    )
                    authDataStorage.setAccessToken(accessToken = token.accessToken)
                    authDataStorage.setRefreshToken(refreshToken = token.refreshToken)
                    authDataStorage.setExpiredAt(expiredAt = token.expiredAt)
                } else throw NeedLoginException("")
            }
            return chain.proceed(
                request.newBuilder().addHeader(
                    "Authorization",
                    "Bearer ${authDataStorage.getAccessToken()}"
                ).build()
            )
        }
        return chain.proceed(request)
    }
}