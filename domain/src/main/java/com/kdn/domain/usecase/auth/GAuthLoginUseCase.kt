package com.kdn.domain.usecase.auth

import com.kdn.domain.model.request.GAuthLoginRequestModel
import com.kdn.domain.repository.auth.AuthRepository
import javax.inject.Inject

class GAuthLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(body: GAuthLoginRequestModel) = kotlin.runCatching {
        authRepository.gAuthLogin(body = body)
    }
}