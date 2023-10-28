package com.kdn.domain.usecase.auth

import com.kdn.domain.repository.auth.AuthRepository
import javax.inject.Inject

class GetRoleInfoUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke() = kotlin.runCatching {

    }
}