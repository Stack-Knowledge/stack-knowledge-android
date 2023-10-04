package com.kdn.data.utils

import com.kdn.data.remote.dto.goods.response.GoodsResponse
import com.kdn.domain.exception.BadRequestException
import com.kdn.domain.exception.ConflictDataException
import com.kdn.domain.exception.ForBiddenException
import com.kdn.domain.exception.InvalidTokenException
import com.kdn.domain.exception.NeedLoginException
import com.kdn.domain.exception.NetworkException
import com.kdn.domain.exception.NotFoundException
import com.kdn.domain.exception.ServerErrorException
import com.kdn.domain.exception.TimeOutException
import com.kdn.domain.exception.UnKnownHttpException
import com.kdn.domain.exception.UnknownException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


class StackApiHandler <T> {
    private lateinit var httpRequest: suspend () -> T

    fun httpRequest(httpRequest: suspend () -> T) =
        this.apply { this.httpRequest = httpRequest }

    suspend fun sendRequest(): T {
        return try {
            withContext(Dispatchers.IO) {
                httpRequest.invoke()
            }
        } catch (e: HttpException) {
            val message = e.message
            throw when(e.code()){
                400 -> BadRequestException(
                    message = message
                )
                401 -> InvalidTokenException(
                    message = message
                )
                403 -> ForBiddenException(
                    message = message
                )
                404 -> NotFoundException(
                    message = message
                )
                409 -> ConflictDataException(
                    message = message
                )
                500, 501, 502, 503 -> ServerErrorException(
                    message = message
                )
                else -> UnKnownHttpException(
                    message = message,
                )
            }
        } catch (e: SocketTimeoutException) {
            throw TimeOutException(message = e.message)
        } catch (e: UnknownHostException) {
            throw NetworkException()
        } catch (e: NeedLoginException) {
            throw NeedLoginException(message = e.message)
        } catch (e: Exception) {
            throw UnknownException(message = e.message)
        }
    }
}