package com.kdn.domain.usecase.student

import com.kdn.domain.param.student.ChangeProfileImageParam
import com.kdn.domain.repository.student.StudentRepository
import javax.inject.Inject

class ChangeProfileImageUseCase @Inject constructor(
    private val studentRepository: StudentRepository,
) {
    suspend operator fun invoke(changeProfileImageParam: ChangeProfileImageParam) = kotlin.runCatching {
        studentRepository.changeProfileImage(changeProfileImageParam)
    }
}