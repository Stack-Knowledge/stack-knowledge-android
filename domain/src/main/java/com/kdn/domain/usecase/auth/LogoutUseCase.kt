package com.kdn.domain.usecase.auth

import com.kdn.domain.repository.auth.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke() = kotlin.runCatching {
        authRepository.logout()
    }
}