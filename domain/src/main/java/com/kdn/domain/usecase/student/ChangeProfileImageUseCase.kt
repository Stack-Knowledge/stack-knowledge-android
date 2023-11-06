package com.kdn.domain.usecase.student

import com.kdn.domain.param.student.ChangeProfileImageParam
import com.kdn.domain.repository.student.StudentRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class ChangeProfileImageUseCase @Inject constructor(
    private val studentRepository: StudentRepository,
) {
    suspend operator fun invoke(image: MultipartBody.Part) = kotlin.runCatching {
        studentRepository.changeProfileImage(image)
    }
}