package com.base.basemodule.sample.http.api

import com.base.basemodule.sample.http.datamodel.CommonErrorDataModel
import com.base.basemodule.sample.http.datamodel.PostDataModel
import com.base.core.http.call.NetworkResponse
import com.base.core.http.call.simple.NetworkSimpleResponse
import retrofit2.http.*

/**
 * Test api
 */
interface AppApi {

    /**
     * 4가지 응답 모델 사용
     */
    @GET("/posts")
    suspend fun getPostList(
        @Query("userId") userId: String
    ): NetworkResponse<ArrayList<PostDataModel>, CommonErrorDataModel>

    /**
     * 2가지 응답 모델 사용
     */
    @GET("/posts")
    suspend fun getPostList2(
        @Query("userId") userId: String
    ): NetworkSimpleResponse<ArrayList<PostDataModel>>

    @POST("/posts")
    @FormUrlEncoded
    suspend fun getPostDetail(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: String,
    ): NetworkSimpleResponse<PostDataModel>


    @PUT("/posts/1")
    @FormUrlEncoded
    suspend fun putPost(
        @Field("id") id: String,
        @Field("userId") userId: String,
        @Field("title") title: String,
        @Field("body") body: String,
    ): NetworkSimpleResponse<PostDataModel>

    @PUT("/posts/1")
    @FormUrlEncoded
    suspend fun patchPost(
        @Field("title") title: String
    ): NetworkSimpleResponse<PostDataModel>

    @DELETE("/posts/1")
    suspend fun deletePost(
    ): NetworkSimpleResponse<PostDataModel>
}
