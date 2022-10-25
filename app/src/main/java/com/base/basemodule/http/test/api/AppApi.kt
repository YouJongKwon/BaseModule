package com.base.basemodule.http.test.api

import com.base.basemodule.http.test.datamodel.CommonErrorDataModel
import com.base.basemodule.http.test.datamodel.FriendDataModel
import com.base.core.http.call.NetworkResponse
import com.base.core.http.call.simple.NetworkSimpleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {

    /**
     * 친구 리스트
     * @param GUBUN
     * LIST : 친구리스트   FRQ_RESPONSE : 받은 요청  FRQ_REQUEST : 보낸 요청
     */
    @GET("api/FRQ_API")
    suspend fun getFriendList(
        @Query("GUBUN") GUBUN: String,
        @Query("USER_ID") USER_ID: String
    ): NetworkResponse<FriendDataModel, CommonErrorDataModel>

    // simple
    @GET("api/FRQ_API")
    suspend fun getFriendList2(
        @Query("GUBUN") GUBUN: String,
        @Query("USER_ID") USER_ID: String
    ): NetworkSimpleResponse<FriendDataModel>

}
