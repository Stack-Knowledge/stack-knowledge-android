package com.kdn.data.remote.dto.student.request

import com.google.gson.annotations.SerializedName
import com.kdn.domain.param.student.ChangeProfileImageParam
import okhttp3.MultipartBody

data class ChangeProfileImageRequest(
    @SerializedName("image")
    val image: MultipartBody.Part,
)

fun ChangeProfileImageParam.toRequest() = ChangeProfileImageRequest(
    image = image
)