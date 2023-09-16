package com.example.stack_knowledge_android.viewmodel

import com.kdn.domain.usecase.GAuthLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val gAuthLoginUseCase: GAuthLoginUseCase
){
}