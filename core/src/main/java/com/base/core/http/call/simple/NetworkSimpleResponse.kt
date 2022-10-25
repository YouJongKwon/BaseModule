package com.base.core.http.call.simple

import java.io.IOException

/**
 * Network 응답 데이터모델
 * @param T : 응답 성공, 받은 데이터 모델
 */
open class NetworkSimpleResponse<T : Any> {

    companion object {
        val ERROR_CODE_API = -400
        val ERROR_CODE_NETWORK = -500
        val ERROR_CODE_UNKNOWN = -999
        var ERROR_MSG_API = "server api error";
        var ERROR_MSG_NETWORK = "network error";
        var ERROR_MSG_UNKNOWN = "unknown error";
    }

    var t : T? = null
    var code : Int? = null
    var errorMsg : String? = ""

    constructor(t: T) {
        this.t = t
    }

    constructor(code: Int, errorMsg: String) {
        this.code = code
        this.errorMsg = errorMsg
    }


//    /**
//     * success response with body
//     */
//    data class Success<T : Any>(val body: T) : NetworkSimpleResponse<T>()
//
//    /**
//     * error
//     */
//    data class Error(val code : Int, val errorMsg: String) : NetworkSimpleResponse<Nothing>()

    fun onResult(onSuccess : (T) ->Unit, onFailed : (Int, String) -> Unit){
        if(t != null){
            onSuccess(t!!)
        }else if(code != null && errorMsg != null){
            onFailed(code!!, errorMsg!!)
        }
    }
}