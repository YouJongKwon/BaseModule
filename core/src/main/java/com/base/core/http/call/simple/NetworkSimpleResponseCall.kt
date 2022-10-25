package com.base.core.http.call.simple

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

internal class NetworkSimpleResponseCall<S : Any>(
    private val delegate: Call<S>
) : Call<NetworkSimpleResponse<S>> {

    override fun enqueue(callback: Callback<NetworkSimpleResponse<S>>) {
        return delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()

                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                            this@NetworkSimpleResponseCall,
                            Response.success(NetworkSimpleResponse(body))
                        )
                    } else {
                        // response is success, but body is null
                        callback.onResponse(
                            this@NetworkSimpleResponseCall,
                            Response.success(NetworkSimpleResponse(NetworkSimpleResponse.ERROR_CODE_API, NetworkSimpleResponse.ERROR_MSG_API))
                        )
                    }
                } else {
                    // error
                    callback.onResponse(
                        this@NetworkSimpleResponseCall,
                        Response.success(NetworkSimpleResponse(NetworkSimpleResponse.ERROR_CODE_API, NetworkSimpleResponse.ERROR_MSG_API))
                    )
                }
            }

            override fun onFailure(call: Call<S>, throwable: Throwable) {
                val networkResponse = when (throwable) {
                    is IOException -> NetworkSimpleResponse<S>(NetworkSimpleResponse.ERROR_CODE_NETWORK, NetworkSimpleResponse.ERROR_MSG_NETWORK) // network error
                    else -> NetworkSimpleResponse<S>(NetworkSimpleResponse.ERROR_CODE_UNKNOWN, NetworkSimpleResponse.ERROR_MSG_UNKNOWN) // unknown error
                }
                callback.onResponse(
                    this@NetworkSimpleResponseCall,
                    Response.success(networkResponse)
                )
            }

        })
    }

    override fun clone(): Call<NetworkSimpleResponse<S>> =
        NetworkSimpleResponseCall(delegate.clone())

    override fun execute(): Response<NetworkSimpleResponse<S>> {
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()

}