package com.kdn.data.remote.dto.student.response

import com.google.gson.annotations.SerializedName
import com.kdn.domain.entity.student.ProfileImageEntity

data class ProfileImageResponse (
    @SerializedName("fileName")
    val fileName: String,
)

fun ProfileImageResponse.toEntity() = ProfileImageEntity(
    fileName = fileName
)