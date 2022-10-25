package com.base.core.http.call

import java.io.IOException

/**
 * Network 응답 데이터모델
 * @param T : 응답 성공, 받은 데이터 모델
 * @param U : 서버에서 api 에러의 경우 errorBodydp 값을 준 경우, 받는 에러 데이터 모델
 */
open class NetworkResponse<out T : Any, out U : Any> {

    /**
     * success response with body
     */
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()

    /**
     * server api error
     */
    data class ApiError<U : Any>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()

    /**
     * network error
     */
    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()

    /**
     * unknown error
     * ex ) json parsing error ..
     */
    data class NetworkError(val error : IOException) : NetworkResponse<Nothing, Nothing>()

}