package com.kdn.domain.usecase.mission

import com.kdn.domain.repository.user.UserRepository
import javax.inject.Inject

class GetSolvedMissionListUseCase @Inject constructor(
    private val userRepository: UserRepository,
){
    suspend operator fun invoke() = kotlin.runCatching {
        userRepository.getSolvedMission()
    }
}