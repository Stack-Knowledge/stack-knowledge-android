package com.kdn.domain.param.student

import okhttp3.MultipartBody

data class ChangeProfileImageParam(
    val image: MultipartBody.Part
)
