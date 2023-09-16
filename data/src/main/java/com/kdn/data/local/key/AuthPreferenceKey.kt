package com.kdn.data.local.key

import androidx.datastore.preferences.core.stringPreferencesKey

object  AuthPreferenceKey {
    val ACCESS_TOKEN = stringPreferencesKey("access_token")

    val REFRESH_TOKEN = stringPreferencesKey("refresh_token")

    val EXPIRE_AT = stringPreferencesKey("expired_at")
}