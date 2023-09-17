package com.kdn.domain.usecase.auth

import com.kdn.domain.model.response.GAuthLoginResponseModel
import com.kdn.domain.repository.AuthRepository
import javax.inject.Inject

class SaveTheLoginDataUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(data: GAuthLoginResponseModel) = kotlin.runCatching {
        authRepository.saveTheLoginData(data)
    }
}