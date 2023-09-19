package com.kdn.domain.utils

sealed class Result<out T>{
    object Loading : Result<Nothing>()
    object UnLoading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Unauthorized(val throwable: Throwable) : Result<Nothing>()
}
