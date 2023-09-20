package com.kdn.stack_knowledge_android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.stack_knowledge_android.utils.Event
import com.kdn.stack_knowledge_android.utils.errorHandling
import com.kdn.domain.model.request.GAuthLoginRequestModel
import com.kdn.domain.model.response.GAuthLoginResponseModel
import com.kdn.domain.usecase.auth.DeleteTokenUseCase
import com.kdn.domain.usecase.auth.GAuthLoginUseCase
import com.kdn.domain.usecase.auth.GetAuthorityInfoUseCase
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
    private val getAuthorityInfoUseCase: GetAuthorityInfoUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase,
) : ViewModel() {
    private val _gAuthLoginRequest = MutableLiveData<Event<GAuthLoginResponseModel>>()
    val gAuthLoginRequest: LiveData<Event<GAuthLoginResponseModel>> get() = _gAuthLoginRequest

    private val _isLoading = MutableLiveData<Event<Event.Loading>>()
    val isLoading: LiveData<Event<Nothing>> get() = isLoading


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
        }.onFailure {
            _saveTokenRequest.value = it.errorHandling(unknownAction = {})
        }
    }

    fun getAuthorityInfo() = viewModelScope.launch {
        getAuthorityInfoUseCase()
            .onSuccess {
                it.catch {remoteError ->
                    _getAuthorityResponse.value = remoteError.errorHandling(unknownAction = {})
                }.collect{ response ->
                    _getAuthorityResponse.value = Event.Success(data = response)
                }
            }.onFailure { error ->
                _getAuthorityResponse.value = error.errorHandling(unknownAction = {})
            }
    }

    fun deleteToken() = viewModelScope.launch {
        deleteTokenUseCase()
    }
}