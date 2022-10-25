package com.base.core.http.call.simple

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkSimpleResponseAdapterFactory : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        // return 타입이 Call 아닌경우 처리
        if(getRawType(returnType) != Call::class.java){
            return null
        }
        check(returnType is ParameterizedType){
            // 타입 체크
            "[todo]"
        }

        val responseType = getParameterUpperBound(0, returnType)
        if(getRawType(responseType) != NetworkSimpleResponse::class.java){
            // 응답 타입이 정의된 NetworkResponse 타입이 아닌경우 지원하지 않음
            return null
        }
        check(responseType is ParameterizedType){
            // 타입 체크
            "[todo]"
        }

        val successBodyType = getParameterUpperBound(0, responseType)
        return NetworkSimpleResponseAdapter<Any>(successBodyType)
    }

}