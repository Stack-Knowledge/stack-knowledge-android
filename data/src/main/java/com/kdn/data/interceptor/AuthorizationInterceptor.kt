package com.kdn.data.interceptor

import com.kdn.data.local.auth.datastorage.AuthDataStorage
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val authDataStorage: AuthDataStorage
) {
}