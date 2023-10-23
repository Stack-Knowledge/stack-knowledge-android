package com.kdn.domain.usecase.student

import com.kdn.domain.repository.student.StudentRepository
import javax.inject.Inject

class GetRankingListUseCase @Inject constructor(
    private val studentRepository: StudentRepository,
) {
    suspend operator fun invoke() = kotlin.runCatching {
        studentRepository.getRankingList()
    }
}