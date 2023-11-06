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
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
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

    fun changeProfileImage(imageFile: File) = viewModelScope.launch {
        val mediaType = "image/${imageFile.extension}".toMediaTypeOrNull()

        val requestBody = RequestBody.create(mediaType, imageFile)
        val part = MultipartBody.Part.createFormData("image", imageFile.name, RequestBody.create(mediaType, imageFile))
        changeProfileImageUseCase(
            part
        ).onSuccess {
            event(Event.ProfileImage(it.toString()))
        }.onFailure {
            Log.e("프로필 사진 업로드 실패", "프로필 사진 업로드에 실패하였습니다.")
        }
    }


    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class MyInfo(val myInfo: MyInfoEntity) : Event()
        data class ProfileImage(val fileName: String) : Event()
    }
}