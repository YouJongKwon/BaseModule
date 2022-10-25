package com.base.core.http

import com.base.core.http.call.NetworkResponseAdapterFactory
import com.base.core.http.call.simple.NetworkSimpleResponseAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {

    private var baseUrl = "";
    private var instance: Retrofit? = null

    fun init(url: String) {
        instance = null
        this.baseUrl = url
    }

    private fun getRetrofit(): Retrofit {
        return if (instance != null) {
            instance!!
        } else {
            instance = Retrofit.Builder()
                .baseUrl(baseUrl)
                //                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(NetworkResponseAdapterFactory()) // success, ( api & network & unknown ) error
                .addCallAdapterFactory(NetworkSimpleResponseAdapterFactory()) // success, failed
                .build()
            instance!!
        }
    }

    fun <T> getApiService(service: Class<T>): T {
        return getRetrofit().create(service)
    }
}