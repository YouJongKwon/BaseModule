package com.base.basemodule.sample.http.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.base.basemodule.sample.http.api.AppApi
import com.base.basemodule.sample.http.datamodel.PostDataModel
import com.base.common.callback.ResponseCallback
import com.base.core.http.RetrofitUtil
import com.base.core.http.call.NetworkResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    fun getPostList(callback: ResponseCallback<ArrayList<PostDataModel>>) {

        GlobalScope.launch {

            val userId = "11"

            // 상세 버전
            val call = RetrofitUtil.getApiService(AppApi::class.java).getPostList(userId)
            when (call) {
                is NetworkResponse.Success -> {
                    Log.d("###", "[get] data : ${call.body}")
                }
                is NetworkResponse.ApiError -> {
                    Log.d("###", "get error data : ${call.body.errorMsg}")
                }
                is NetworkResponse.NetworkError -> {
                    Log.d("###", "Network Error : ${call.error.localizedMessage}")
                }
                is NetworkResponse.UnknownError -> {
                    Log.d("###", "Unknown Error : ${call.error?.localizedMessage}")
                }
            }

            RetrofitUtil.getApiService(AppApi::class.java).getPostList2(userId).onResult({
                callback.onSuccess(it)
            }, { code, msg ->
                callback.onFailed(code, msg)
            })

        }


    }

    fun getPostDetail(callback: ResponseCallback<PostDataModel>) {

        val title = "foo"
        val body = "(post)"
        val userId = "1"

        GlobalScope.launch {
            RetrofitUtil.getApiService(AppApi::class.java).getPostDetail(title, body, userId)
                .onResult({
                    callback.onSuccess(it)
                }, { code, msg ->
                    callback.onFailed(code, msg)
                })
        }
    }

    fun putPost(callback: ResponseCallback<PostDataModel>) {

        val title = "foo"
        val body = "(put)"
        val userId = "1"
        val id = "1"

        GlobalScope.launch {
            RetrofitUtil.getApiService(AppApi::class.java).putPost(id, userId, title, body)
                .onResult({
                    callback.onSuccess(it)
                }, { code, msg ->
                    callback.onFailed(code, msg)
                })
        }
    }

    fun patchPost(callback: ResponseCallback<PostDataModel>) {
        val title = "foo2"

        GlobalScope.launch {
            RetrofitUtil.getApiService(AppApi::class.java).patchPost(title)
                .onResult({
                    callback.onSuccess(it)
                }, { code, msg ->
                    callback.onFailed(code, msg)
                })
        }
    }

    fun deletePost(callback: ResponseCallback<PostDataModel>) {

        GlobalScope.launch {
            RetrofitUtil.getApiService(AppApi::class.java).deletePost()
                .onResult({
                    callback.onSuccess(it)
                }, { code, msg ->
                    callback.onFailed(code, msg)
                })
        }
    }
}