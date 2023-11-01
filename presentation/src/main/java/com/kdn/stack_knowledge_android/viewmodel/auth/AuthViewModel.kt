package com.kdn.stack_knowledge_android.viewmodel.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.stack_knowledge_android.utils.error.Event
import com.kdn.stack_knowledge_android.utils.error.errorHandling
import com.kdn.domain.model.request.auth.GAuthLoginRequestModel
import com.kdn.domain.model.response.auth.GAuthLoginResponseModel
import com.kdn.domain.usecase.auth.GAuthLoginUseCase
import com.kdn.domain.usecase.auth.GetRoleInfoUseCase
import com.kdn.domain.usecase.auth.SaveTheLoginDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val gAuthLoginUseCase: GAuthLoginUseCase,
    private val saveTheLoginDataUseCase: SaveTheLoginDataUseCase,
    private val getRoleInfoUseCase: GetRoleInfoUseCase,
) : ViewModel() {

    private val _gAuthLoginRequest = MutableLiveData<Event<GAuthLoginResponseModel>>()
    val gAuthLoginRequest: LiveData<Event<GAuthLoginResponseModel>> get() = _gAuthLoginRequest

    private val _saveTokenRequest = MutableLiveData<Event<Nothing>>()
    val saveTokenRequest: LiveData<Event<Nothing>> get() = _saveTokenRequest

    private val _saveAuthorityResponse = MutableStateFlow<Event<Unit>>(Event.Loading)
    val saveAuthorityResponse = _saveAuthorityResponse.asStateFlow()

    private val _getAuthorityResponse = MutableStateFlow<Event<String>>(Event.Loading)
    val getAuthorityResponse = _getAuthorityResponse.asStateFlow()

    fun gAuthLogin(code: String) = viewModelScope.launch {
        gAuthLoginUseCase(
            GAuthLoginRequestModel(code = code)
        ).onSuccess {
            it.catch { remoteError ->
                _gAuthLoginRequest.value = remoteError.errorHandling(unknownAction = {})
            }.collect { response ->
                _gAuthLoginRequest.value = Event.Success(data = response)
            }
        }.onFailure {
            _gAuthLoginRequest.value = it.errorHandling(unknownAction = {})
        }
    }

    fun saveTheLoginData(data: GAuthLoginResponseModel) = viewModelScope.launch {
        saveTheLoginDataUseCase(
            data = data
        ).onSuccess {
            _saveTokenRequest.value = Event.Success()
            Log.e("로그인 정보 저장 성공", "$it")
        }.onFailure {
            _saveTokenRequest.value = it.errorHandling(unknownAction = {})
            Log.e("로그인 정보 저장 실패", "$it")
        }
    }

    fun getRoleInfo() = viewModelScope.launch {
        getRoleInfoUseCase()
            .onSuccess {
                it.catch { remoteError ->
                    _getAuthorityResponse.value = remoteError.errorHandling(unknownAction = {})
                }.collect { response ->
                    _getAuthorityResponse.value = Event.Success(data = response)
                }
            }.onFailure { error ->
                _getAuthorityResponse.value = error.errorHandling(unknownAction = {})
            }
    }
}