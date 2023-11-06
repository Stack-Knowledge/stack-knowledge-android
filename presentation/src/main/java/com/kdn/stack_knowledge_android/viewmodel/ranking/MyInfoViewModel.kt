package com.kdn.stack_knowledge_android.viewmodel.ranking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kdn.domain.entity.student.MyInfoEntity
import com.kdn.domain.param.student.ChangeProfileImageParam
import com.kdn.domain.usecase.student.ChangeProfileImageUseCase
import com.kdn.domain.usecase.student.GetMyInfoUseCase
import com.kdn.stack_knowledge_android.utils.MutableEventFlow
import com.kdn.stack_knowledge_android.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val getMyInfoUseCase: GetMyInfoUseCase,
    private val changeProfileImageUseCase: ChangeProfileImageUseCase,
) : ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun getMyInfo() = viewModelScope.launch {
        getMyInfoUseCase().onSuccess {
            event(Event.MyInfo(it))
        }.onFailure {
            Log.e("내정보 가져오기 실패", "실패 $it")
        }
    }

    fun saveProfileImage(imageUri: File) = viewModelScope.launch{
        val mediaType = "image/*".toMediaTypeOrNull()

        val requestBody = RequestBody.create(mediaType, imageUri)
        val part = MultipartBody.Part.createFormData("image", imageUri.name, requestBody)

        val changeProfileImageParam = ChangeProfileImageParam(part)

        _eventFlow.emit(Event.ProfileImage(changeProfileImageParam))
    }

    fun changeProfileImage(imageFile: File) = viewModelScope.launch {
        val mediaType = "image/*".toMediaTypeOrNull()

        val requestBody = RequestBody.create(mediaType, imageFile)
        val part = MultipartBody.Part.createFormData("image", imageFile.name, requestBody)

        val changeProfileImageParam = ChangeProfileImageParam(part)

        changeProfileImageUseCase(
            changeProfileImageParam
        ).onSuccess {
            _eventFlow.emit(Event.ProfileImage(changeProfileImageParam))
        }
            .onFailure {

            }
    }


    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class MyInfo(val myInfo: MyInfoEntity) : Event()
        data class ProfileImage(val changeProfileImage: ChangeProfileImageParam) : Event()
    }
}