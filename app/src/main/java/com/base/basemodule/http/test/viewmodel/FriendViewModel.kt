package com.base.basemodule.http.test.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.base.basemodule.http.test.api.AppApi
import com.base.basemodule.http.test.datamodel.FriendDataModel
import com.base.common.callback.ResponseCallback
import com.base.core.http.RetrofitUtil
import com.base.core.http.call.NetworkResponse
import com.base.core.http.call.simple.NetworkSimpleResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FriendViewModel : ViewModel() {

    companion object {
        val TYPE_REQUEST = 1 // 보낸 요청
        val TYPE_RESPONSE = 2 // 받은 요청
    }

    suspend fun getRequestFriendList(type: Int, callback: ResponseCallback<FriendDataModel>) {

        GlobalScope.launch {

        }
        val GUBUN = if (type == TYPE_REQUEST) "FRQ_REQUEST" else "FRQ_RESPONSE";
        val USER_ID = "M2209190001"

//        RetrofitUtil.getApiService(AppApi::class.java).getFriendList(GUBUN, USER_ID).enqueue(object : Callback<FriendDataModel>{
//            override fun onResponse(
//                call: Call<FriendDataModel>,
//                response: Response<FriendDataModel>
//            ) {
//                Log.d("###", "data : ${response.body().toString()}")
//            }
//
//            override fun onFailure(call: Call<FriendDataModel>, t: Throwable) {
//                Log.d("###", "data : ${t.localizedMessage}")
//            }
//
//        })

//        RetrofitUtil.getApiService(AppApi::class.java).getFriendList(GUBUN, USER_ID)
//            .enqueue(onSuccess = {
//
//                // 응답 성공 !!
//                Log.d("###", "data : $it")
//
//            }, onFailed = { code, msg ->
//
//                // 에러 !!
//                Log.d("###", "code : $code, msg : $msg")
//
//            })


        val call = RetrofitUtil.getApiService(AppApi::class.java).getFriendList(GUBUN, USER_ID)
        when (call) {
            is NetworkResponse.Success -> {
                Log.d("###", "data : ${call.body.DATA.toString()}")
            }
            is NetworkResponse.ApiError -> {
                Log.d("###", "data : ${call.body.errorMsg}")
            }
            is NetworkResponse.NetworkError -> {
                Log.d("###", "Network Error")
            }
            is NetworkResponse.UnknownError -> {
                Log.d("###", "Unknown Error")
            }
        }

        RetrofitUtil.getApiService(AppApi::class.java).getFriendList2(GUBUN, USER_ID).onResult({
            Log.d("###", "data : ${it.toString()}")
        }, { code, msg ->
            Log.d("###", "code : $code, msg : $msg")
        })


    }

}