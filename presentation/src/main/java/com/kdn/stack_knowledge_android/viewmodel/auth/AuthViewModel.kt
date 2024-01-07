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
import com.kdn.domain.usecase.auth.AutoLoginUseCase
import com.kdn.domain.usecase.auth.DeleteTokenUseCase
import com.kdn.domain.usecase.auth.GAuthLoginUseCase
import com.kdn.domain.usecase.auth.GetRoleInfoUseCase
import com.kdn.domain.usecase.auth.LogoutUseCase
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
    private val authLoginUseCase: AutoLoginUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase,
) : ViewModel() {

    private val _logoutResponse = MutableStateFlow<Event<Unit>>(Event.Loading)
    val logoutResponse = _logoutResponse.asStateFlow()

    private val _gAuthLoginRequest = MutableLiveData<Event<GAuthLoginResponseModel>>()
    val gAuthLoginRequest: LiveData<Event<GAuthLoginResponseModel>> get() = _gAuthLoginRequest

    private val _saveTokenRequest = MutableLiveData<Event<Nothing>>()
    val saveTokenRequest: LiveData<Event<Nothing>> get() = _saveTokenRequest

    private val _getAuthorityResponse = MutableStateFlow<String>("")
    val getAuthorityResponse = _getAuthorityResponse.asStateFlow()

    private val _saveRoleResponse = MutableStateFlow<Event<Unit>>(Event.Loading)
    val saveRoleResponse = _saveRoleResponse.asStateFlow()

    private val _autoLoginStatus = MutableLiveData<String?>(null)
    val autoLoginStatus: LiveData<String?> get() = _autoLoginStatus

    fun gAuthLogin(code: String) = viewModelScope.launch {
        gAuthLoginUseCase(
            GAuthLoginRequestModel(code = code)
        ).onSuccess {
            it.catch { remoteError ->
                _gAuthLoginRequest.value = remoteError.errorHandling(unknownAction = {})
            }.collect { response ->
                _getAuthorityResponse.emit(response.authority)
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

    fun autoLogin() = viewModelScope.launch {
        authLoginUseCase()
            .onSuccess {
                _autoLoginStatus.value = it
            }.onFailure {
                Log.e("자동 로그인 실패", "$it")
            }
    }

    fun logout() = viewModelScope.launch {
        logoutUseCase()
            .onSuccess {
                _logoutResponse.value = Event.Success(data = it)
                deleteTokenUseCase()
            }.onFailure {
                _logoutResponse.value = it.errorHandling(unknownAction = {})
            }
    }
}
