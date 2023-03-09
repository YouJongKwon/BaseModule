package com.base.basemodule.sample.http.datamodel
import com.google.gson.annotations.SerializedName


data class PostDataModel(
    @SerializedName("body")
    var body: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: String
) {

    override fun toString(): String {
        return "PostDataModel(body='$body', id=$id, title='$title', userId='$userId')"
    }
}