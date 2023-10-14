package com.kdn.domain.usecase.auth

import com.kdn.domain.repository.auth.AuthRepository
import javax.inject.Inject

class DeleteTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke() {
        repository.deleteLoginData()
    }
}