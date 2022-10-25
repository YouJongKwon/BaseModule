package com.base.core.http.call.simple

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

class NetworkSimpleResponseAdapter<S : Any>(
    private val successType : Type
) : CallAdapter<S, Call<NetworkSimpleResponse<S>>> {

    override fun responseType(): Type  = successType

    override fun adapt(call: Call<S>): Call<NetworkSimpleResponse<S>> {
        return NetworkSimpleResponseCall(call)
    }


}